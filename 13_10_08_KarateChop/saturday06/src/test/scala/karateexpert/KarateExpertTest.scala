package karateexpert

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class KarateExpertSpec extends FlatSpec with Matchers {
  it should "break tiles and search target" in {
    val targetAndTilesAndExpected =
      Table(
        ("target", "tiles", "expected"),
        (3, List(), None),
        (3, List(1), None),
        (1, List(1), Some(0)),
        (1, List(1, 3, 5), Some(0)),
        (3, List(1, 3, 5), Some(1)),
        (5, List(1, 3, 5), Some(2)),
        (0, List(1, 3, 5), None),
        (2, List(1, 3, 5), None),
        (4, List(1, 3, 5), None),
        (6, List(1, 3, 5), None),
        (1, List(1, 3, 5, 7), Some(0)),
        (3, List(1, 3, 5, 7), Some(1)),
        (5, List(1, 3, 5, 7), Some(2)),
        (7, List(1, 3, 5, 7), Some(3)),
        (0, List(1, 3, 5, 7), None),
        (2, List(1, 3, 5, 7), None),
        (4, List(1, 3, 5, 7), None),
        (6, List(1, 3, 5, 7), None),
        (8, List(1, 3, 5, 7), None))
    forAll(targetAndTilesAndExpected) { (target: Int, tiles: List[Int], expected: Option[Int]) =>
      val karateExpert = new KarateExpert
      karateExpert.chop(target, tiles) should be(expected)
    }
  }
}
