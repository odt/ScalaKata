package io.github.joker1007

import scala.io.Source

class WeatherDataReader(source : Source) {
  def withData[U](f : WeatherData => U) {
    for(line <- source.getLines()) {
      WeatherDataParser.parseDataLine(line) match {
        case Some(d) => f(d)
        case None => Unit
      }
    }
  }
}

object WeatherDataParser {
  private[this] val regex = """\A\s+(\d+)\s+(\d+)\s+(\d+)\s+.*\Z""".r

  def parseDataLine(line : String) : Option[WeatherData] = {
    for {
      valid <- regex findFirstIn line
      regex(day, maxTemp, minTemp) = valid
    } yield WeatherData(day, maxTemp.toInt, minTemp.toInt)
  }
}
