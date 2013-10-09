package io.github.kazoo04.palindrome

import scala.annotation.tailrec

object NextPalindrome {

  @tailrec
  def next(num: Int): Int = {
    var n = num + 1

    if(n.toString == n.toString.reverse){
      return n
    }
    
    next(n)
  }

}
