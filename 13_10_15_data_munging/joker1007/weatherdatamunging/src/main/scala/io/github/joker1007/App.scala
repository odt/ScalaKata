package io.github.joker1007

import scala.io.Source
import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]) {
    val parser = args(0) match {
      case "-w" => WeatherDataParser
      case "-f" => FootballDataParser
      case _ => WeatherDataParser
    }
    val source = Source.fromFile(args(1))

    val reader = new WebDataReader(source, parser)

    val listBuffer = new ListBuffer[WebData]()
    reader withData (listBuffer.+=)
    val weatherData = listBuffer.minBy(_.targetDifference)

    printf("%s %2d%n", weatherData.key, weatherData.targetDifference)
  }
}
