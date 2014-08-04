import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

import date.Date
import pparser.PParser

class RackSpec extends FunSpec with ShouldMatchers {
  describe("PParser#parse") {
    it ("should parse an input line") {
      PParser("./13_10_09_next_palindrome/joker1007").parse match {
        case (date, name) => {
          date should equal(Date(2013,10,9))
          name should equal("joker1007")
        }
      }
    }
  }
}
