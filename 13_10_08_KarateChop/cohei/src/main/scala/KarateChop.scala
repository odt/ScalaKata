package karate_chop

import scala.annotation.tailrec

object KarateChop {
  def main(args: Array[String]) = {
    println(binSearch(4, List(1,2,4,8)))
  }

  def binSearch[A <% Ordered[A]](y: A, xs: Seq[A]): Int = {
    toResult(binSearchHelper(0, xs.length - 1, y, xs))
  }

  private def toResult(x: Option[Int]):Int = x.getOrElse(-1)

  @tailrec
  private def binSearchHelper[A <% Ordered[A]](min: Int, max: Int, y: A, xs: Seq[A]): Option[Int] = {
    if (min > max) return None

    val mid = (min + max) / 2

    xs(mid) match {
      case x if (y == x) => Some(mid)
      case x if (y <  x) => binSearchHelper(min,     mid - 1, y, xs)
      case x if (y >  x) => binSearchHelper(mid + 1, max,     y, xs)
    }
  }
}
