package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class PalindromesSpec extends FlatSpec with Matchers {
  it should "convert Int to List[Int]" in {
    Palindromes.intToDigitList(1) should be(List(1))
    Palindromes.intToDigitList(2) should be(List(2))
    Palindromes.intToDigitList(20) should be(List(2, 0))
    Palindromes.intToDigitList(12345) should be(List(1, 2, 3, 4, 5))
  }

  it should "convert List[Int] to Int" in {
    Palindromes.digitListToInt(List(1)) should be(1)
    Palindromes.digitListToInt(List(2)) should be(2)
    Palindromes.digitListToInt(List(2, 0)) should be(20)
    Palindromes.digitListToInt(List(1, 2, 3, 4, 5)) should be(12345)
  }

  it should "calculate next palindrome" in {
    val targetAndTilesAndExpected =
      Table(
        ("input", "next"),
        (10, 11)
        //(2, 3),
        //(8, 9),
        //(9, 11),
        //(100, 101),
        //(89890, 89898),
        //(213123212, 213131312)
      )
    forAll(targetAndTilesAndExpected) {
      (input: Int, next: Int) =>
        Palindromes.next(input) should be(next)
    }
  }
}
