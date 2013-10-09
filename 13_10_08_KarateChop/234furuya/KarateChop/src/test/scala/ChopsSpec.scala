/**
 * Created with IntelliJ IDEA.
 * User: furuya234
 * Date: 13/10/09
 * Time: 13:34
 * To change this template use File | Settings | File Templates.
 */
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class ChoppsSpec extends FunSpec with ShouldMatchers {
  describe("chop_int") {
    it("3 in []") {
      Chops.chop_int(3, List()) should equal (-1)
    }
    it("3 in [1]") {
      Chops.chop_int(3, List(1)) should equal (-1)
    }
    it("1 in [1]") {
      Chops.chop_int(1, List(1)) should equal (0)
    }
    it("1 in [1, 3, 5]") {
      Chops.chop_int(1, List(1, 3, 5)) should equal (0)
    }
    it("3 in [1, 3, 5]") {
      Chops.chop_int(3, List(1, 3, 5)) should equal (1)
    }
    it("5 in [1, 3, 5]") {
      Chops.chop_int(5, List(1, 3, 5)) should equal (2)
    }
    it("0 in [1, 3, 5]") {
      Chops.chop_int(0, List(1, 3, 5)) should equal (-1)
    }
    it("2 in [1, 3, 5]") {
      Chops.chop_int(2, List(1, 3, 5)) should equal (-1)
    }
    it("4 in [1, 3, 5]") {
      Chops.chop_int(4, List(1, 3, 5)) should equal (-1)
    }
    it("6 in [1, 3, 5]") {
      Chops.chop_int(6, List(1, 3, 5)) should equal (-1)
     }
    it("1 in [1, 3, 5, 7]") {
      Chops.chop_int(1, List(1, 3, 5, 7)) should equal (0)
    }
    it("3 in [1, 3, 5, 7]") {
      Chops.chop_int(3, List(1, 3, 5, 7)) should equal (1)
    }
    it("5 in [1, 3, 5, 7]") {
      Chops.chop_int(5, List(1, 3, 5, 7)) should equal (2)
    }
    it("7 in [1, 3, 5, 7]") {
      Chops.chop_int(7, List(1, 3, 5, 7)) should equal (3)
    }
    it("0 in [1, 3, 5, 7]") {
      Chops.chop_int(0, List(1, 3, 5, 7)) should equal (-1)
    }
    it("2 in [1, 3, 5, 7]") {
      Chops.chop_int(2, List(1, 3, 5, 7)) should equal (-1)
    }
    it("4 in [1, 3, 5, 7]") {
      Chops.chop_int(4, List(1, 3, 5, 7)) should equal (-1)
    }
    it("6 in [1, 3, 5, 7]") {
      Chops.chop_int(6, List(1, 3, 5, 7)) should equal (-1)
    }
    it("8 in [1, 3, 5, 7]") {
      Chops.chop_int(8, List(1, 3, 5, 7)) should equal (-1)
    }
    it("14 in 0..30") {
      Chops.chop_int(14, List.range(0, 30)) should equal (14)
    }
  }
}
