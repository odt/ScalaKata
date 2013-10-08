package jp.co.usagee.akausagi.chop

/**
 * Created with IntelliJ IDEA.
 * User: akausagi
 * Date: 13/10/08
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
object KarateChop {
  def chop(target: Int, sorted_list: List[Int], low_index: Int = 0): Int = {
    return sorted_list.indexOf(target)
  }

}
