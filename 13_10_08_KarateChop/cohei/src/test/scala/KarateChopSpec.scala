package karate_chop

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class KarateChopSpec extends FunSpec with ShouldMatchers {
  describe("chop_int") {
    it("3 in []") {
      KarateChop.binSearch(3, List()) should equal (-1)
    }
    it("3 in [1]") {
      KarateChop.binSearch(3, List(1)) should equal (-1)
    }
    it("1 in [1]") {
      KarateChop.binSearch(1, List(1)) should equal (0)
    }
    it("1 in [1, 3, 5]") {
      KarateChop.binSearch(1, List(1, 3, 5)) should equal (0)
    }
    it("3 in [1, 3, 5]") {
      KarateChop.binSearch(3, List(1, 3, 5)) should equal (1)
    }
    it("5 in [1, 3, 5]") {
      KarateChop.binSearch(5, List(1, 3, 5)) should equal (2)
    }
    it("0 in [1, 3, 5]") {
      KarateChop.binSearch(0, List(1, 3, 5)) should equal (-1)
    }
    it("2 in [1, 3, 5]") {
      KarateChop.binSearch(2, List(1, 3, 5)) should equal (-1)
    }
    it("4 in [1, 3, 5]") {
      KarateChop.binSearch(4, List(1, 3, 5)) should equal (-1)
    }
    it("6 in [1, 3, 5]") {
      KarateChop.binSearch(6, List(1, 3, 5)) should equal (-1)
     }
    it("1 in [1, 3, 5, 7]") {
      KarateChop.binSearch(1, List(1, 3, 5, 7)) should equal (0)
    }
    it("3 in [1, 3, 5, 7]") {
      KarateChop.binSearch(3, List(1, 3, 5, 7)) should equal (1)
    }
    it("5 in [1, 3, 5, 7]") {
      KarateChop.binSearch(5, List(1, 3, 5, 7)) should equal (2)
    }
    it("7 in [1, 3, 5, 7]") {
      KarateChop.binSearch(7, List(1, 3, 5, 7)) should equal (3)
    }
    it("0 in [1, 3, 5, 7]") {
      KarateChop.binSearch(0, List(1, 3, 5, 7)) should equal (-1)
    }
    it("2 in [1, 3, 5, 7]") {
      KarateChop.binSearch(2, List(1, 3, 5, 7)) should equal (-1)
    }
    it("4 in [1, 3, 5, 7]") {
      KarateChop.binSearch(4, List(1, 3, 5, 7)) should equal (-1)
    }
    it("6 in [1, 3, 5, 7]") {
      KarateChop.binSearch(6, List(1, 3, 5, 7)) should equal (-1)
    }
    it("8 in [1, 3, 5, 7]") {
      KarateChop.binSearch(8, List(1, 3, 5, 7)) should equal (-1)
    }
    it("14 in 0..30") {
      KarateChop.binSearch(14, List.range(0, 30)) should equal (14)
    }
  }
}
