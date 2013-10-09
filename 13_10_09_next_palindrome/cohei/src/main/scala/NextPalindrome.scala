import scala.io._
import scala.collection.immutable.Stream

object NextPalindrome {
  def main(args: Array[String]) = {
    val in = Source.fromInputStream(System.in)
    val lines = in.getLines.toList

    lines.drop(1).foreach { s: String => println(nextPalindrome(s.toInt)) }
    // sbt run で標準入出力がうまく渡せないため検証できず
  }

  def nextPalindrome(n: Int): Int = {
    from(n+1).filter(isPalindrome(_)).head
  }

  private def from(n: Int): Stream[Int] = {
    n #:: from(n+1)
  }

  private def isPalindrome(n: Int): Boolean = {
    val ds = digits(n)
    ds == ds.reverse
  }

  // 逆順になるが今回は関係ない
  private def digits(n: Int): List[Int] = {
    if (n == 0) return List()

    val q = n / 10
    val r = n % 10

    r :: digits(q)
  }
}
