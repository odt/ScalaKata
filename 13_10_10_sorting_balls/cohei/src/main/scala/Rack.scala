import scalaz._

case class Rack[A: Order](balls: Seq[A] = Seq()) {
  def add(ball: A): Rack[A] = copy(insert(ball, balls))

  private def insert(y: A, xs: Seq[A]): Seq[A] = {
    xs match {
      case Seq()           => Seq(y)
      case Seq(x, xs @ _*) => Order[A].order(y,x) match {
        case Ordering.GT => x +: insert(y, xs)
        case _           => y +: x +: xs
      }
    }
  }
}
