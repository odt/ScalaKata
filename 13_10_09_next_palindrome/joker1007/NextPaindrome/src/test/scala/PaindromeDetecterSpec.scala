import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import io.github.joker1007.PaindromeDetecter

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/09
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
class PaindromeDetecterSpec extends FunSpec with ShouldMatchers {
  describe("next") {
    describe("Given 123456") {
      it("should equal 124421") {
        PaindromeDetecter.next(123456) should equal (124421)
      }
    }

    describe("Given 12365") {
      it("should equal 12421") {
        PaindromeDetecter.next(12365) should equal (12421)
      }
    }

    describe("Given 1236552") {
      it("should equal 1236552") {
        PaindromeDetecter.next(1236552) should equal (1237321)
      }
    }
  }
}
