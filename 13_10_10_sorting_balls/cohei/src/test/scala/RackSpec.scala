import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class RackSpec extends FunSpec with ShouldMatchers {
  describe("SortingBalls#add, balls") {
    it ("should be empty") {
      Rack.init.balls should equal(List())
    }

    it ("add 20") {
      Rack.init.add(20).balls should equal(List(20))
    }

    it ("add 10") {
      Rack.init.add(20).add(10).balls should equal(List(10, 20))
    }

    it ("add 30") {
      Rack.init.add(20).add(10).add(30).balls should equal(List(10, 20, 30))
    }
  }
}
