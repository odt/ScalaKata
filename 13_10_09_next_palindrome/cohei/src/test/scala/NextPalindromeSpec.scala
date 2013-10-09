import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class KarateChopSpec extends FunSpec with ShouldMatchers {
  describe("nextPalindrome") {
    it("818 for 808") {
      NextPalindrome.nextPalindrome(808) should equal (818)
    }

    it("2222 for 2133") {
      NextPalindrome.nextPalindrome(2133) should equal (2222)
    }
  }
}
