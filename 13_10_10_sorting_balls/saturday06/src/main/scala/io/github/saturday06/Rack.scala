package io.github.saturday06

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

class Rack {
  var balls_ : List[Int] = Nil
  def balls: List[Int] = balls_

  @tailrec
  private[this] def chop(value: Int, array: List[Int], offset: Int): Int = {
    if (array.length == 0) {
      return offset
    }
    val index = array.length / 2
    array(index) match {
      case compareValue if compareValue > value => chop(value, array.slice(0, index), offset)
      case compareValue if compareValue < value => chop(value, array.slice(index + 1, array.length), offset + index + 1)
      case _ => offset + index
    }
  }

  def chop(value: Int, array: List[Int]): Int = {
    chop(value, array, 0)
  }

  def add(ball: Int) = {
    val (before, after) = balls_.splitAt(chop(ball, balls_))
    balls_ = before ::: List(ball) ::: after
  }
}
