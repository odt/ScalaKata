package test.scala

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import io.github.joker1007.Chop

/**
 * Created with IntelliJ IDEA.
 * User: joker
 * Date: 2013/10/08
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
class ChopSpec extends FunSpec with ShouldMatchers {
  describe("chop") {
    describe("given 3, Array(1,3,5,7)") {
      it("should equal 1") {
        Chop.chop(3, Array(1,3,5,7)) should equal(1)
      }
    }
    describe("given 5, Array(1,3,5,7)") {
      it("should equal 2") {
        Chop.chop(5, Array(1,3,5,7)) should equal(2)
      }
    }
    describe("given 8, Array(1,3,5,7)") {
      it("should equal -1") {
        Chop.chop(8, Array(1,3,5,7)) should equal(-1)
      }
    }
  }
}
