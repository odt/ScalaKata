/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 2013/10/08
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */

object Chop {
  def chop(n : Int, list : Array[Int]) : Int = {
    tryChop(n, list) match {
      case Some(x) => x
      case None => -1
    }
  }

  private[this] def tryChop(n : Int, list : Array[Int]) : Option[Int] = {
    list match {
      case Array(a, b) =>
        if (n == a)
          return Some(0)
        if (n == b)
          return Some(1)
        None
      case Array(a) =>
        if (n == a)
          return Some(0)
        None
      case Array() => None
      case list =>
        val pivot = list.length / 2
        list(pivot) match {
          case x if n == x => Some(pivot)
          case x if n < x => tryChop(n, list.take(pivot))
          case x if n > x =>
            for {
              r <- tryChop(n, list.drop(pivot + 1))
            } yield r + pivot + 1
        }
    }
  }
}
