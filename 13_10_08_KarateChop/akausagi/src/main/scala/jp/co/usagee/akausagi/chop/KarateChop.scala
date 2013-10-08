package jp.co.usagee.akausagi.chop

/**
 * Created with IntelliJ IDEA.
 * User: akausagi
 * Date: 13/10/08
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
object KarateChop {
  def chop(target: Int, sorted_list: List[Int]): Int = {
    if(sorted_list.length == 0) return -1
    var left_index = 0
    var right_index = sorted_list.length - 1

    while(left_index <= right_index){
      var middle_index = (right_index+left_index)/2
      var middle_value = sorted_list(middle_index)
      middle_value match {
        case x if x == target => return middle_index
        //左側にターゲットがある場合
        case x if target < x => right_index = middle_index - 1
        //右側にターゲットがある場合
        case x if target > x => left_index = middle_index + 1
        case _ => return -1
      }
    }
    return -1
  }

}
