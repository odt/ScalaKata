package karate_chop

import scala.annotation.tailrec

object KarateChop {
  def main(args: Array[String]) = {
    println(binSearch(4, Vector()))
  }

  def binSearch(y: Int, xs: Seq[Int]): Int = {
    toResult(binSearchHelper(0, xs.length - 1, y, xs))
  }

  private def toResult(x: Option[Int]):Int = x getOrElse -1

  @tailrec
  private def binSearchHelper(min: Int, max: Int, y: Int, xs: Seq[Int]): Option[Int] = {
    if (min > max) return None

    val mid = (min + max) / 2

    xs(mid) match {
      case x if (y == x) => Some(mid)
      case x if (y <  x) => binSearchHelper(min,     mid - 1, y, xs)
      case x if (y >  x) => binSearchHelper(mid + 1, max,     y, xs)
    }
  }
}
