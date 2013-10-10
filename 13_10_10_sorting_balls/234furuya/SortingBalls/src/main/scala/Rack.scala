/**
 * Created with IntelliJ IDEA.
 * User: furuya234
 * Date: 13/10/10
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
object Rack {
  var balls = List[Int]()

  def main(args: Array[String]) {
    add(20)
    add(10)
    add(30)

    println(balls)
  }

  def add(num: Int) {
    balls = balls ::: List[Int](num)
    balls = balls.sorted
  }

}
