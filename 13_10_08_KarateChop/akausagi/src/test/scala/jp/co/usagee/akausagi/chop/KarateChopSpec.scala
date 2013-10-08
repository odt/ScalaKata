package jp.co.usagee.akausagi.chop
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
/**
 * Created with IntelliJ IDEA.
 * User: akausagi
 * Date: 13/10/08
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */


class KarateChopSpec extends FunSpec with ShouldMatchers {
  describe("chop") {
    it("3 in []") {
      KarateChop.chop(3, List()) should equal (-1)
    }
    it("3 in [1]") {
      KarateChop.chop(3, List(1)) should equal (-1)
    }
    it("1 in [1]") {
      KarateChop.chop(1, List(1)) should equal (0)
    }
    it("1 in [1, 3, 5]") {
      KarateChop.chop(1, List(1, 3, 5)) should equal (0)
    }
    it("3 in [1, 3, 5]") {
      KarateChop.chop(3, List(1, 3, 5)) should equal (1)
    }
    it("5 in [1, 3, 5]") {
      KarateChop.chop(5, List(1, 3, 5)) should equal (2)
    }
    it("0 in [1, 3, 5]") {
      KarateChop.chop(0, List(1, 3, 5)) should equal (-1)
    }
    it("2 in [1, 3, 5]") {
      KarateChop.chop(2, List(1, 3, 5)) should equal (-1)
    }
    it("4 in [1, 3, 5]") {
      KarateChop.chop(4, List(1, 3, 5)) should equal (-1)
    }
    it("6 in [1, 3, 5]") {
      KarateChop.chop(6, List(1, 3, 5)) should equal (-1)
    }
    it("1 in [1, 3, 5, 7]") {
      KarateChop.chop(1, List(1, 3, 5, 7)) should equal (0)
    }
    it("3 in [1, 3, 5, 7]") {
      KarateChop.chop(3, List(1, 3, 5, 7)) should equal (1)
    }
    it("5 in [1, 3, 5, 7]") {
      KarateChop.chop(5, List(1, 3, 5, 7)) should equal (2)
    }
    it("7 in [1, 3, 5, 7]") {
      KarateChop.chop(7, List(1, 3, 5, 7)) should equal (3)
    }
    it("0 in [1, 3, 5, 7]") {
      KarateChop.chop(0, List(1, 3, 5, 7)) should equal (-1)
    }
    it("2 in [1, 3, 5, 7]") {
      KarateChop.chop(2, List(1, 3, 5, 7)) should equal (-1)
    }
    it("4 in [1, 3, 5, 7]") {
      KarateChop.chop(4, List(1, 3, 5, 7)) should equal (-1)
    }
    it("6 in [1, 3, 5, 7]") {
      KarateChop.chop(6, List(1, 3, 5, 7)) should equal (-1)
    }
    it("8 in [1, 3, 5, 7]") {
      KarateChop.chop(8, List(1, 3, 5, 7)) should equal (-1)
    }
    it("14 in 0..30") {
      KarateChop.chop(14, List.range(0, 30)) should equal (14)
    }
  }
}