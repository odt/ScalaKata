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
    (for ((digit, index) <- digits.reverse.zipWithIndex) yield {
      Math.pow(10, index).toInt * digit
    }).sum
  }

  def next(value: Int): Int = {
    if (value < 9) {
      return value + 1
    }
    val digits = toDigits(value + 1)
    val reversedHigh = toInt(digits.take(digits.size / 2).reverse)
    val low = toInt(digits.takeRight(digits.size / 2))
    val highAndCenter = toInt(digits.take((digits.size.toDouble / 2).ceil.toInt))
    val nextHighAndCenterDigits = toDigits(highAndCenter + (if (reversedHigh < low) 1 else 0))
    val nextLowDigits = nextHighAndCenterDigits.dropRight(digits.size % 2).reverse
    toInt(nextHighAndCenterDigits ::: nextLowDigits)
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
