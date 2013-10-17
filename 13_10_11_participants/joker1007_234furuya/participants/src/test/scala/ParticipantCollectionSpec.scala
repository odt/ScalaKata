import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import io.github.joker1007.{ParticipantCollection, Participant, Date}

class ParticipantCollectionSpec extends FunSpec with ShouldMatchers{
  val input =
    """
      |./13_10_08_KarateChop/234furuya
      |./13_10_08_KarateChop/akausagi
      |./13_10_08_KarateChop/cohei
      |./13_10_08_KarateChop/joker1007
      |./13_10_08_KarateChop/naga41
      |./13_10_08_KarateChop/saturday06
      |./13_10_09_next_palindrome/cohei
      |./13_10_09_next_palindrome/joker1007
    """.stripMargin

  describe("parseFileList") {
    it ("should parse Kata file list and return ParticipantCollection") {
      val col = ParticipantCollection.parseFileList(input)
      col.onDate(Date(2013, 10, 9)) should equal (Set(Participant("cohei"), Participant("joker1007")))
      col.onDate(Date(2013, 10, 8)) should equal (("234furuya" :: "akausagi" :: "cohei" :: "joker1007" :: "naga41" :: "saturday06" :: Nil map (Participant)).toSet)
    }
  }

  describe("toMap") {
    it ("should return Map[Date, Set[Participant]]") {
      val col = ParticipantCollection.parseFileList(input)
      col.toMap(Date(2013, 10, 9)) should equal (Set(Participant("cohei"), Participant("joker1007")))
    }
  }
}
