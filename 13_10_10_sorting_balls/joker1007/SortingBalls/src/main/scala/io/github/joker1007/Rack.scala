package io.github.joker1007

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/10
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
class Rack[T <% Ordered[T]] {
  private[this] var sortedBalls : RedBlackTree[T] with Rootable[T] = Empty[T]()

  def balls : List[T] = sortedBalls.toList

  def add(item : T) {
    sortedBalls = sortedBalls.add(item)
  }
}
