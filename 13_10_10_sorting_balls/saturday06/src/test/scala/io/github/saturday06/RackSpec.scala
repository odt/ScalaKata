package io.github.saturday06

import org.scalatest._
import org.scalatest.prop.TableDrivenPropertyChecks._

class RackSpec extends FlatSpec with Matchers {
  it should "search insertion index" in {
    val rack = new Rack
    rack.chop(0, List(1, 2)) should be (0)
    rack.chop(1, List(1, 2)) should be (0)
    rack.chop(1, List(1, 2)) should be (0)
    rack.chop(2, List(1, 2)) should be (1)
    rack.chop(2, List(1, 3)) should be (1)
    rack.chop(3, List(1, 2)) should be (2)
  }
  
  it should "sort balls" in {
    val rack = new Rack
    rack.balls should be(List())
    rack.add(20)
    rack.balls should be(List(20))
    rack.add(10)
    rack.balls should be(List(10, 20))
    rack.add(30)
    rack.balls should be(List(10, 20, 30))
  }
}
