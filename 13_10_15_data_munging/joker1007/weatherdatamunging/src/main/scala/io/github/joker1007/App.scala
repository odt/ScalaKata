package io.github.joker1007

import scala.io.Source
import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]) {
    val source = Source.fromFile(args(0))
    val reader = new WeatherDataReader(source)

    val listBuffer = new ListBuffer[WeatherData]()
    reader withData (listBuffer.+=)
    val weatherData = listBuffer.minBy(_.temperatureSpread)

    printf("%2d %2d%n", weatherData.day.toInt, weatherData.temperatureSpread)
  }
}
