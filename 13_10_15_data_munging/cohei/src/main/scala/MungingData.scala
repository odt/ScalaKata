// import scalaz._
import scala.io._

object MungingData {
  def main(args: Array[String]) = {
    val source = Source.fromFile("weather.dat")
    val lines = source.getLines.toList.drop(8)

  }

  def words(s: String) = {
    s.split(' ')
  }
  // StringLike#split


}
