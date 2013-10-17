import org.scalatest.FunSpec
import io.github.joker1007.{Rack, Empty}
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 13/10/10
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
class RackSpec extends FunSpec with ShouldMatchers {
  describe("balls"){
    it ("is always sorted") {
      val rack = new Rack[Int]()
      rack.add(20)
      rack.add(10)
      rack.add(30)
      rack.add(40)
      rack.add(38)
      rack.add(5)

      rack.balls should equal (List(5, 10, 20, 30, 38, 40))
    }
  }
}
