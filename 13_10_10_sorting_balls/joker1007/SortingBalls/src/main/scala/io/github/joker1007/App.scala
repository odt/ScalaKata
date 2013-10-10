package io.github.joker1007

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/10
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
object App {
  def main(args: Array[String]) {
    val rack = new Rack[Int]()

    rack.add(20)
    println(rack.balls)
    rack.add(10)
    println(rack.balls)
    rack.add(30)
    println(rack.balls)
  }
}
