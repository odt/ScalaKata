package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class PalindromesSpec extends FlatSpec with Matchers {
  it should "calculate next palindrome" in {
    val targetAndTilesAndExpected =
      Table(
        ("input", "next"),
        (1, 2),
        (2, 3),
        (8, 9),
        (9, 11),
        (100, 101),
        (89890, 89898),
        (213123212, 213131312))
    forAll(targetAndTilesAndExpected) { (input: Int, next: Int) =>
      Palindromes.next(input) should be (next)
    }
  }
}
