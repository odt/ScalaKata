package io.github.joker1007

import scala.io.Source

object App {
  def main(args: Array[String]) {
    val source = Source.fromFile(args(0))
    val parser = new WeatherDataParser
    val datas = source.getLines map (parser.parseDataLine(_))
    val minSpread = datas minBy {
      case Some(d) => d.minimumTemperature
      case None => Int.MaxValue
    }
    println(minSpread)
  }
}
