import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import _root_.JavaVersion

class JavaVersionSpec extends FlatSpec with ShouldMatchers {
  "JavaVersion.validate(str)" should "return true if str is valid java version string" in {
    JavaVersion.validate(JDK7u40) should be (true)
  }
}
