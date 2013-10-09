/**
 * Created with IntelliJ IDEA.
 * User: furuya234
 * Date: 13/10/09
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
object Chops {
  def main(args: Array[String]) {
    val chopped = chop_int(1,List[Int](1,2))
    println(chopped)
  }

  def chop_int(num: Int, list: List[Int]): Int = {
    if (list.length == 0) return -1
    var half_len = list.length/2
    val sorted_li = list.sorted
    for (i <- 0 to list.length-1) {
      if ( num == list(i) ) return i
    }
    return -1
  }
}
