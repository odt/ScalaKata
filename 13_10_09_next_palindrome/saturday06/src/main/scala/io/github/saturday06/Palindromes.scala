package io.github.saturday06

import scala.annotation.tailrec
import scala.math._
import scala.collection.mutable.ListBuffer

object Palindromes {
  def intToDigitList(value: Int): List[Int] = {
    if (value > 0) {
      intToDigitList(value / 10) ::: List(value % 10)
    } else {
      List[Int]()
    }
  }

  def digitListToInt(digitList: List[Int]): Int = {
    if (digitList.length > 1) {
      digitList.last + digitListToInt(digitList.dropRight(1)) * 10
    } else {
      digitList.last
    }
  }

  def next(value: Int): Int = {
    // 前半より後半の逆順のほうが大きい場合、前半を後半の逆順につけて終了
    
    11
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
