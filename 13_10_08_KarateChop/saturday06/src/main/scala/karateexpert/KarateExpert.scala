package karateexpert

import scala.annotation.tailrec

class KarateExpert {
  @tailrec
  private def chop(value: Int, array: List[Int], offset: Int): Option[Int] = {
    if (array.length == 0) {
      return None
    }
    val index = array.length / 2
    array(index) match {
      case compareValue if compareValue > value => chop(value, array.slice(0, index), offset)
      case compareValue if compareValue < value => chop(value, array.slice(index + 1, array.length), offset + index + 1)
      case _ => Some(offset + index)
    }
  }

  def chop(value: Int, array: List[Int]): Option[Int] = {
    chop(value, array, 0)
  }
}
