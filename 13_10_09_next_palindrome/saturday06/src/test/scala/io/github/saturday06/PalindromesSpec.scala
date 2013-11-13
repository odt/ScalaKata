package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class PalindromesSpec extends FlatSpec with Matchers {
  it should "convert Int to List[Int]" in {
    Palindromes.toDigits(1) should be(List(1))
    Palindromes.toDigits(2) should be(List(2))
    Palindromes.toDigits(20) should be(List(2, 0))
    Palindromes.toDigits(12345) should be(List(1, 2, 3, 4, 5))
  }

  it should "convert List[Int] to Int" in {
    Palindromes.toInt(List(1)) should be(1)
    Palindromes.toInt(List(2)) should be(2)
    Palindromes.toInt(List(2, 0)) should be(20)
    Palindromes.toInt(List(1, 2, 3, 4, 5)) should be(12345)
  }

  it should "calculate next palindrome" in {
    val targetAndTilesAndExpected =
      Table(
        ("input", "next"),
        (10, 11),
        (20, 22),
        (500, 505),
        (2, 3),
        (8, 9),
        (9, 11),
        (99, 101),
        (100, 101),
        (89890, 89898),
        (213123212, 213131312)
      )
    forAll(targetAndTilesAndExpected) {
      (input: Int, next: Int) =>
        Palindromes.next(input) should be(next)
    }
  }
}
