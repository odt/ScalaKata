package io.github.saturday06

object Palindromes {
  def toDigits(value: Int): List[Int] = {
    if (value > 0) {
      toDigits(value / 10) ::: List(value % 10)
    } else {
      List[Int]()
    }
  }

  def toInt(digits: List[Int]): Int = {
    if (digits.length > 1) {
      digits.last + toInt(digits.dropRight(1)) * 10
    } else {
      digits.last
    }
  }

  def next(value: Int): Int = {
    if (value < 9) {
      return value + 1
    }
    val digits = toDigits(value + 1)
    val high = toInt(digits.take(digits.size / 2))
    val low = toInt(digits.takeRight(digits.size / 2).reverse)
    val highAndCenter = toInt(digits.take((digits.size.toDouble / 2).ceil.toInt))
    toInt(toDigits(highAndCenter + (if (high < low) 1 else 0)) ::: toDigits(high).reverse)
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
