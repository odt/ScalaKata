import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import io.github.joker1007.{WeatherDataParser, WeatherData}

class WeatherDataParserSpec extends FunSpec with ShouldMatchers {
  describe("#parseDataLine") {
    val line1 = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
    val line2 = "  10  84    64    74          57.5       0.00 F       210  6.6 050   9  3.4  84 40 1019.0"
    val invalidLine = "invalid 12 46 00"

    it("parse line into WeatherData") {
      WeatherDataParser.parseDataLine(line1) should equal (Some(WeatherData("1", 88, 59)))
      WeatherDataParser.parseDataLine(line2) should equal (Some(WeatherData("10", 84, 64)))
      WeatherDataParser.parseDataLine(invalidLine) should equal (None)
    }
  }
}
