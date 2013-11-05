package io.github.joker1007

import org.scalatest.{ShouldMatchers, FlatSpec}

class WeatherDataParserSpec extends FlatSpec with ShouldMatchers {
  def parser = new WeatherDataParser

  "WeatherDataParser" should "parse data line" in {
    val result = parser.parseDataLine("""   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5""")
    result.get.maximumTemperature should equal (88)
    result.get.minimumTemperature should equal (59)
  }

  it should "return None if invalid Stream" in {
    val result = parser.parseDataLine(""" 1 A B C """)
    result shouldBe empty
  }
}
