package io.github.saturday06

import scala.annotation.tailrec
import scala.math._

object Palindromes {
  @tailrec
  def next(value: Int): Int = {
    val nextValue = value + 1
    if (check(nextValue)) {
      nextValue
    } else {
      next(nextValue)
    }
  }

  def check(value: Int): Boolean = {
    if (value < 10) {
      return true
    }
    val tailDigit = value % 10
    val rank = pow(10, log10(value).floor).toInt
    val headDigit = value / rank
    if (tailDigit == headDigit) {
      return check((value - tailDigit - headDigit * rank) / 10)
    }
    return false
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    val lines = scala.io.Source.stdin.getLines()
    val last = lines.next().trim().toInt
    for (i <- 0 until last) {
      println(Palindromes.next(lines.next().trim().toInt))
    }
  }
}
