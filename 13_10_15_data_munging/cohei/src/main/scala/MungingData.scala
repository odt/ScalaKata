// import scalaz._
import scala.io._

object MungingData {
  def main(args: Array[String]) = {
    val source = Source.fromFile("weather.dat")
    source.getLines foreach println
  }

  // StringLike#split


}
