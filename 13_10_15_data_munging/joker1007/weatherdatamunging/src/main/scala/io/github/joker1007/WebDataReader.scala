package io.github.joker1007

import scala.io.Source
import scala.util.matching.Regex


class WebDataReader(source : Source, parser : WebDataParser) {
  def withData(f : WebData => Any) {
    for(line <- source.getLines()) {
      parser.parseDataLine(line) match {
        case Some(d) => f(d)
        case None => Unit
      }
    }
  }
}

trait WebDataParser {
  private val regex : Regex = new Regex("")

  def parseDataLine(line : String) : Option[WebData]
}

object WeatherDataParser extends WebDataParser {
  private val regex :Regex = """\A\s+(\d+)\s+(\d+)\s+(\d+)\s+.*\Z""".r

  def parseDataLine(line : String) : Option[WeatherData] = {
    for {
      valid <- regex findFirstIn line
      regex(day, maxTemp, minTemp) = valid
    } yield WeatherData(day, maxTemp.toInt, minTemp.toInt)
  }
}

object FootballDataParser extends WebDataParser {
  private val regex :Regex = """\A\s+\d+\.\s+(\w+)\s+\d+\s+\d+\s+\d+\s+\d+\s+(\d+)\s+\-\s+(\d+)\s+.*\Z""".r

  def parseDataLine(line : String) : Option[FootballData] = {
    for {
      valid <- regex findFirstIn line
      regex(team, forGoal, againstGoal) = valid
    } yield FootballData(team, forGoal.toInt, againstGoal.toInt)
  }
}
