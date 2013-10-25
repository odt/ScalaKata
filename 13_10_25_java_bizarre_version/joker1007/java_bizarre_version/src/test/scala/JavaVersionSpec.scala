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

  "JavaVersion.parse" should "parse version string into Option[JavaVersion] instance" in {
    JavaVersion.parse("JDK7u40").isInstanceOf[Option[JavaVersion]] should be (true)
  }

  "JavaVersion.parse" should "assign parsed string into property" in {
    val Some(javaVersion) = JavaVersion.parse("JDK8u60")
    javaVersion.familyNumber should equal (8)
    javaVersion.updateNumber should equal (60)
  }

  "JavaVersion.parse" should "return None when parse invalid version" in {
    JavaVersion.parse("JDK7u9x") should equal (None)
  }

  "JavaVersion(7, 40)" should "be lower than JavaVersion(7, 41)" in {
    JavaVersion(7, 40) should be < JavaVersion(7, 41)
  }

  "JavaVersion(6, 40)" should "be lower than JavaVersion(7, 40)" in {
    JavaVersion(6, 40) should be < JavaVersion(7, 40)
  }

  "JavaVersion(7, 41)" should "be lower than JavaVersion(8, 40)" in {
    JavaVersion(7, 41) should be < JavaVersion(8, 40)
  }
}
