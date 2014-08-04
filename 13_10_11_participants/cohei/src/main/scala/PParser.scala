package pparser

import util.parsing.combinator._
import date.Date

case class PParser(input: String) extends RegexParsers {
  def parse = parseAll(parser, input).get

  private val number = "[0-9]".r ^^ (_.toInt)

  private val twoDigitNumber = (number ~ number) ^^ { case n ~ m => n * 10 + m }

  private val takeUntilSlash = "[^/]+".r ~ "/"

  private val date =
    repN(3, twoDigitNumber <~ "_") ^^ { case List(y,m,d) => Date(y + 2000, m, d) }

  private val name = "[a-zA-Z0-p]".r.* ^^ (_.mkString)

  private val parser =
    ("./" ~> date <~ takeUntilSlash) ~ name ^^ { case date ~ name  => (date, name) }
}
