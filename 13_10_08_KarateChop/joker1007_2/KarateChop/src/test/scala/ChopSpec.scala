package test.scala

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.junit.JUnitRunner

import io.github.joker1007.Chop

@RunWith(classOf[JUnitRunner])
class ChopSpec extends FlatSpec with ShouldMatchers {
  trait WithCollection {
    val col = List(1,3,5,7)
  }

  trait WithLargeCollection {
    val col = Range(1, 1000000, 2).toList
  }

  "Chop.chop" should "search given value from collection" in new WithCollection {
    Chop.chop[Int](5, col) shouldEqual 2
  }

  it should "return -1 if given not included value" in new WithCollection {
    Chop.chop[Int](10, col) shouldEqual -1
  }

  it should "search given value from large collection" in new WithLargeCollection {
    Chop.chop[Int](5, col) shouldEqual 2
  }

  it should "return -1 if given not included value by large collection" in new WithLargeCollection {
    Chop.chop[Int](10, col) shouldEqual -1
  }
}
