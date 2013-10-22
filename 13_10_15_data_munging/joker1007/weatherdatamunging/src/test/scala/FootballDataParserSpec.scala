import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

import io.github.joker1007.{FootballData,FootballDataParser}

class FootballDataParserSpec extends FunSpec with ShouldMatchers {
  describe("#parseDataLine") {
    val line1 = "    1. Arsenal         38    26   9   3    79  -  36    87"
    val line2 = "    2. Liverpool       38    24   8   6    67  -  30    80"
    val line3 = "       Team            P     W    L   D    F      A     Pts"

    it("parse line into FootballData") {
      FootballDataParser.parseDataLine(line1) should equal (Some(FootballData("Arsenal", 79, 36)))
      FootballDataParser.parseDataLine(line2) should equal (Some(FootballData("Liverpool", 67, 30)))
      FootballDataParser.parseDataLine(line3) should equal (None)
    }
  }
}
