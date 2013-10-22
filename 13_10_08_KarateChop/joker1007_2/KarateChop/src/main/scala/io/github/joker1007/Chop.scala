package io.github.joker1007

import scala.annotation.tailrec

object Chop {
  def chop[A <% Ordered[A]](value: A, col: Seq[A]) : Int = {
    chop(value, col, 0).getOrElse(-1)
  }

  @tailrec
  private[this] def chop[A <% Ordered[A]](value: A, col: Seq[A], offset: Int) : Option[Int] = {
    col match {
      case Seq(a) => if (value == a) Some(0 + offset) else None

      case Seq(a, b) => {
        if (value == a)
          return Some(0 + offset)
        if (value == b)
          return Some(1 + offset)
        None
      }

      case _ => {
        val pivot = col.length / 2
        val pivotValue = col(pivot)

        if (value == pivotValue)
          return Some(pivot + offset)

        if (value > pivotValue)
          chop(value, col.drop(pivot + 1), pivot + 1)
        else
          chop(value, col.take(pivot), offset)
      }
    }
  }
}
