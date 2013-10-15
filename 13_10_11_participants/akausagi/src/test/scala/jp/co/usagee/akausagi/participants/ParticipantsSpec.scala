package jp.co.usagee.akausagi.participants
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.BeforeAndAfter

import java.util.Date

/**
 * Created with IntelliJ IDEA.
 * User: akausagi
 * Date: 13/10/08
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 */


class ParticipantsSpec extends FunSpec with ShouldMatchers with BeforeAndAfter {
  var fileList:String = null
  var participants:Participants = null
  before {
    fileList =
      """
        |./13_10_08_KarateChop/234furuya
        |./13_10_08_KarateChop/akausagi
        |./13_10_08_KarateChop/cohei
        |./13_10_08_KarateChop/joker1007
        |./13_10_08_KarateChop/naga41
        |./13_10_08_KarateChop/saturday06
        |./13_10_09_next_palindrome/cohei
        |./13_10_09_next_palindrome/joker1007""".stripMargin
    participants = new Participants(fileList) // fileList は上の文字列
  }
  describe("participants") {
    it("2013/10/9 include cohei and joker1007") {
      //月が0～11なので一ヶ月ずれ
      participants.onDate(new Date(2013,10-1,9)) should equal (Array("cohei", "joker1007"))
    }
  }
}