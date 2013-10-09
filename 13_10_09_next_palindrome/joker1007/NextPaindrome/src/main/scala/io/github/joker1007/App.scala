package io.github.joker1007

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/09
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
object App {
  def main(args: Array[String]) {
    println(PaindromeDetecter.next(1211))
    println(PaindromeDetecter.next(1251))
    println(PaindromeDetecter.next(12311))
    println(PaindromeDetecter.next(12345))
    println(PaindromeDetecter.next(12))
    println(PaindromeDetecter.next(32))
    println(PaindromeDetecter.next(2))
  }
}
