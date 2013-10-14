package io.github.joker1007

import scala.collection.mutable.ListBuffer


sealed abstract class RedBlackTree[T <% Ordered[T]] extends Traversable[T] {
  def insert(x : T) : Node[T]

  def balance : RedBlackTree[T]

  def foreach[U](f : T => U) = this match {
    case Empty() => Unit
    case Leaf() => Unit
    case Node(_, l, v, r) => l foreach f; f(v); r foreach f
  }

  override def toList : List[T] = {
    val listBuffer: ListBuffer[T] = ListBuffer()
    foreach(listBuffer.+=)
    listBuffer.toList
  }
}

trait Rootable[T] {
  def add(x : T) : Node[T]
}

case class Empty[T <% Ordered[T]]() extends RedBlackTree[T] with Rootable[T]{
  def insert(x : T) : Node[T] = Node[T](Black(), Leaf(), x, Leaf())
  def add(x : T) : Node[T] = insert(x)

  def balance : RedBlackTree[T] = this
}

private case class Leaf[T <% Ordered[T]]() extends RedBlackTree[T] {
  def insert(x : T) : Node[T] = {
    Node[T](Red(), Leaf(), x, Leaf()).balance
  }

  def balance: RedBlackTree[T] = this
}

case class Node[T <% Ordered[T]](color : NodeColor, left : RedBlackTree[T], value : T, right : RedBlackTree[T])
  extends RedBlackTree[T] with Rootable[T] {

  def add(x : T) = {
    val tree = insert(x)
    tree match {
      case Node(Red(), l, v, r) => Node[T](Black(), l, v, r)
      case Node(Black(), _, _, _) => tree
    }
  }

  def insert(x : T) : Node[T] = {
    if (x > value)
      copy(right = right.insert(x)).balance
    else
      copy(left = left.insert(x)).balance
  }

  def balance: Node[T] = {
    color match {
      case Red() => this
      case Black() =>
        this match {
          case Node(_, Node(Red(), Node(Red(), Leaf(), v2, Leaf()), v1, Leaf()), v, r) =>
            copy(Red(), Node(Black(), Leaf(), v2, Leaf()), v1, Node(Black(), Leaf(), v, r))
          case Node(_, Node(Red(), Leaf(), v1, Node(Red(), Leaf(), v2, Leaf())), v, r) =>
            copy(Red(), Node(Black(), Leaf(), v1, Leaf()), v2, Node(Black(), Leaf(), v, r))
          case Node(_, l, v, Node(Red(), Node(Red(), Leaf(), v2, Leaf()), v1, Leaf())) =>
            copy(Red(), Node(Black(), l, v, Leaf()), v2, Node(Black(), Leaf(), v1, Leaf()))
          case Node(_, l, v, Node(Red(), Leaf(), v1, Node(Red(), Leaf(), v2, Leaf()))) =>
            copy(Red(), Node(Black(), l, v, Leaf()), v1, Node(Black(), Leaf(), v2, Leaf()))
          case _ =>
            this
        }
    }
  }
}

sealed abstract class NodeColor

private case class Red() extends NodeColor

private case class Black() extends NodeColor

