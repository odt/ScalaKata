package io.github.joker1007

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/09
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
object PaindromeDetecter {
  def next(k : Int) : Int = {
    val kString = k.toString()
    val kLevel = kString.length
    if (kLevel == 1)
      return k + 1

    if ((kLevel % 2) == 0) {
      return evenLevel(k, kString, kLevel)
    } else {
      return oddLevel(k, kString, kLevel)
    }
  }

  private[this] def evenLevel(k : Int, kString : String, kLevel : Int) : Int = {
    val prefix = kString.substring(0, kLevel / 2)
    val suffix = kString.substring(kLevel / 2, kLevel)

    if (prefix.reverse.toInt >= suffix.toInt) {
      return k + prefix.reverse.toInt - suffix.toInt
    } else {
      val newPrefix = (prefix.toInt + 1).toString()
      return k + ("1" + newPrefix.reverse).toInt - suffix.toInt
    }
  }

  private[this] def oddLevel(k : Int, kString : String, kLevel : Int) : Int = {
    val prefix = kString.substring(0, kLevel / 2)
    val center = kString.substring(kLevel / 2, kLevel / 2 + 1)
    val suffix = kString.substring(kLevel / 2 + 1, kLevel)
    if (prefix.reverse.toInt >= suffix.toInt) {
      return k + prefix.reverse.toInt - suffix.toInt
    } else {
      val newPrefix = (prefix.toInt + 1).toString()
      return (prefix + (center.toInt + 1).toString() + prefix.reverse).toInt
    }
  }
}
