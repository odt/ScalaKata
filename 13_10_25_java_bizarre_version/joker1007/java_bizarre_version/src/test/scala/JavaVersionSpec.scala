import io.github.joker1007.JavaVersion
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

trait VersionBehavior { this: FlatSpec with ShouldMatchers =>
  def validVersion(str: String) {
    it should "return true" in {
      JavaVersion.validate(str) should be (true)
    }
  }

  def invalidVersion(str: String) {
    it should "return false" in {
      JavaVersion.validate(str) should be (false)
    }
  }
}

class JavaVersionSpec extends FlatSpec with ShouldMatchers with VersionBehavior {
  "JDK7u40"  should behave like validVersion("JDK7u40")
  "JDK10u40" should behave like validVersion("JDK10u40")
  "JDK10u40" should behave like invalidVersion("JDK0u40")
  "JDK7u9x"  should behave like invalidVersion("JDK7u9x")
  "JDK07u9x" should behave like invalidVersion("JDK07u9x")
  "JDK7u0"   should behave like invalidVersion("JDK7u0")
  "JDK7u1"   should behave like validVersion("JDK7u1")
}
