/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 2013/10/08
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */
object App {
  def main(args: Array[String]) {
    println(Chop.chop(1, Array(1)))
    println(Chop.chop(1, Array()))
    println(Chop.chop(3, Array(1,3)))
    println(Chop.chop(5, Array(1,3,5,7)))
    println(Chop.chop(7, Array(1,3,5,7)))
    println(Chop.chop(8, Array(1,3,5,7)))
    assert(Chop.chop(3, Array(1,3)) == 1)
  }
}
