package io.github.saturday06

import scala.annotation.tailrec
import scala.collection.immutable.HashMap
import java.util.Date

class Participants(private val fileList: String) {
  private val participantsByDate = fileList.lines.toList
		  .groupBy(line => dateFromLine(line))
		  .mapValues(lines => lines.map(line => userFromLine(line)))

  def dateFromLine(line: String): Date = {
    val ymd = line.split("/")(1).split("_")
    new Date(ymd(0).toInt + 2000, ymd(1).toInt, ymd(2).toInt)
  }

  def userFromLine(line: String): String = {
    line.split("/")(2)
  }

  def byDate(): Map[Date, List[String]] = {
    participantsByDate
  }
}
