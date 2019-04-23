package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import scala.annotation.tailrec

class PalindromesSpec extends FunSpec with Matchers {
  describe("toDigits") {
    it("converts Int to List[Int]") {
      Palindromes.toDigits(1) should be(List(1))
      Palindromes.toDigits(2) should be(List(2))
      Palindromes.toDigits(20) should be(List(2, 0))
      Palindromes.toDigits(12345) should be(List(1, 2, 3, 4, 5))
    }
  }

  describe("toInt") {
    it("converts List[Int] to Int") {
      Palindromes.toInt(List(1)) should be(1)
      Palindromes.toInt(List(2)) should be(2)
      Palindromes.toInt(List(2, 0)) should be(20)
      Palindromes.toInt(List(1, 2, 3, 4, 5)) should be(12345)
    }
  }

  describe("next") {
    it("matches kazoo04's algorithm") {
      @tailrec
      def kazoo04(value: Int): Int = {
        val nextValue = value + 1
        if (nextValue.toString == nextValue.toString.reverse) {
          nextValue
        } else {
          kazoo04(nextValue)
        }
      }

      List.range(1, 123456).foreach(input => {
        val next = kazoo04(input)
        Palindromes.next(input) should be(next)
      })
    }

    it("calculates next palindrome") {
      val targetAndTilesAndExpected =
        Table(
          ("input", "next"),
          (1, 2),
          (8, 9),
          (9, 11),
          (10, 11),

          (11, 22),
          (88, 99),
          (99, 101),
          (100, 101),
          (101, 111),

          (998, 999),
          (999, 1001),
          (1000, 1001),

          (1210, 1221),
          (1212, 1221),
          (1213, 1221),
          (1220, 1221),
          (1221, 1331),

          (2110, 2112),
          (2111, 2112),
          (2112, 2222),
          (2113, 2222),

          (12010, 12021),
          (12012, 12021),
          (12013, 12021),
          (12020, 12021),
          (12021, 12121),

          (21010, 21012),
          (21011, 21012),
          (21012, 21112),
          (21013, 21112),

          (12910, 12921),
          (12912, 12921),
          (12913, 12921),
          (12920, 12921),
          (12921, 13031),

          (21910, 21912),
          (21911, 21912),
          (21912, 22022),
          (21913, 22022),

          (129421, 129921),
          (213123212, 213131312)
        )
      forAll(targetAndTilesAndExpected) {
        (input: Int, next: Int) =>
          Palindromes.next(input) should be(next)
      }
    }
  }
}

