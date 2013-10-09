package karate_chop

import scala.annotation.tailrec
import scalaz._

object KarateChop {
  def main(args: Array[String]) = {
    println(binSearch(4, List(1,2,4,8)))
  }

  def binSearch[A: Order](y: A, xs: Seq[A]): Int = {
    toResult(binSearchHelper(0, xs.length - 1, y, xs))
  }

  private def toResult(x: Option[Int]):Int = x.getOrElse(-1)

  @tailrec
  private def binSearchHelper[A: Order](min: Int, max: Int, y: A, xs: Seq[A]): Option[Int] = {
    if (min > max) return None

    val mid = (min + max) / 2

    Order[A].order(y, xs(mid)) match {
      case Ordering.EQ => Some(mid)
      case Ordering.LT => binSearchHelper(min,     mid - 1, y, xs)
      case Ordering.GT => binSearchHelper(mid + 1, max,     y, xs)
    }
  }
}
