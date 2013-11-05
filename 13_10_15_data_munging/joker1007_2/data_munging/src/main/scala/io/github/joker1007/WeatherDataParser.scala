package io.github.joker1007

import scala.util.parsing.combinator.RegexParsers

class WeatherDataParser extends RegexParsers {
  val digitValue: Parser[String] = """[\d\.]+""".r
  val wxType: Parser[String] = """[A-Z]""".r
  val value: Parser[String] = digitValue | wxType
  val data: Parser[List[String]] = rep(rep(whiteSpace) ~> value)

  private[this] val maximumTemperatureIndex = 1
  private[this] val minimumTemperatureIndex = 2

  def parseDataLine(line: String): Option[WeatherData] = {
    parseAll(data, line) match {
      case Success(result, in) =>
        Some(WeatherData(result(maximumTemperatureIndex).toInt, result(minimumTemperatureIndex).toInt))
      case Failure(_, _) => None
      case Error(_, _) => None
    }
  }
}
