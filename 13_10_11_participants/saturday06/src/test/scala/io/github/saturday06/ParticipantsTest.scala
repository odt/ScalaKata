package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._
import java.util.Date

class ParticipantsSpec extends FlatSpec with Matchers {
  it should "parse single line" in {
    val in = "./13_10_08_KarateChop/234furuya"
    val participants = new Participants(in)
    val date = new Date(2013, 10, 8)
    val map = participants.byDate()
    map(date) should equal (List("234furuya"))
  }
  
  it should "get date" in {
    val participants = new Participants("")
    participants.dateFromLine("./13_10_08_karate/234") should equal (new Date(2013, 10, 8))
  }

  it should "get user" in {
    val participants = new Participants("")
    participants.userFromLine("./13_10_08_karate/234") should equal ("234")
  }

  it should "parse multi lines" in {
  }
}
