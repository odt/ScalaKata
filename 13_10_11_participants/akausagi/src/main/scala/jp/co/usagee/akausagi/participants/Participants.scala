package jp.co.usagee.akausagi.participants

import java.util.{Calendar, Date}
import java.text.SimpleDateFormat

/**
 * Created with IntelliJ IDEA.
 * User: akausagi
 * Date: 13/10/08
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
class Participants(arg:String) {
  val fileList = arg

  def onDate(date:Date): Array[String] = {
    val files = fileList.lines.toArray
    val df = new SimpleDateFormat("yy_MM_dd");
    val date_str = df.format(date)
    val days_files = files.filter(file => file.indexOf(date_str) != -1)
    return days_files.map(_.split('/').last).filter(_ != "")
  }

}
