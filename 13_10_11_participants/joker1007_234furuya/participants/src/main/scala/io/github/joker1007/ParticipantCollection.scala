package io.github.joker1007

import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/11
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
class ParticipantCollection(table : List[(Date, Participant)]) {
  def onDate(date : Date) : Set[Participant] = {
    ((table filter (_._1 == date)) map (_._2)).toSet
  }

  def toMap : Map[Date, Set[Participant]] = {
    val temp: Map[Date, List[(Date, Participant)]] = table.groupBy(_._1)
    temp mapValues (list =>
      (list map (_._2)).toSet
    )
  }
}

object ParticipantCollection {
  def parseFileList(filelist : String) : ParticipantCollection = {
    val parsed = filelist.split("\n") map parseLine
    val init = Nil : List[(Date, Participant)]
    val table = parsed.foldLeft(init)((acc, d) =>
      d match {
        case None => acc
        case Some(x) => x :: acc
      }
    )
    new ParticipantCollection(table)
  }

  private[this] def parseLine(line : String) : Option[(Date, Participant)] = {
    val regex = """\./(\d\d)_(\d\d)_(\d\d)_(.*)/(.*)""".r
    for {
      regex(year,month,day,project,name) <- regex findFirstIn line
    } yield (Date(year.toInt + 2000, month.toInt, day.toInt), Participant(name))
  }
}
