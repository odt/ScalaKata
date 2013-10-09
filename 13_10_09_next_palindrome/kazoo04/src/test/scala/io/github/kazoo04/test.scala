package io.github.kazoo04.palindrome

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class test extends FunSpec with ShouldMatchers{
  describe("palindrome") {
    it("should return 1 when given 0") {
      NextPalindrome.next(0) should equal (1)
    }
    
    it("should return 9 when given 11") {
      NextPalindrome.next(9) should equal (11)
    }

    it("should return 818 when given 808") {
      NextPalindrome.next(808) should equal (818)
    }

    it("should return 2222 when given 2133") {
      NextPalindrome.next(2133) should equal (2222)
    }

    it("should return 9990 when given 9999") {
      NextPalindrome.next(9) should equal (11)
    }
    
    it("should return 12345 when given 13131") {
      NextPalindrome.next(9) should equal (11)
    }
  }
}
