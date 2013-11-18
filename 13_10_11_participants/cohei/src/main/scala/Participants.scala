// import scalaz._

import date.Date
import pparser.PParser

object Participants {
  def main(args: Array[String]) = {
    println(PParser("./13_10_09_next_palindrome/joker1007").parse)
  }
}
