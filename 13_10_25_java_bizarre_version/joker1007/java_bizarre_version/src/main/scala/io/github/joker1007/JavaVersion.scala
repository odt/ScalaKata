package io.github.joker1007

case class JavaVersion(familyNumber: Int, updateNumber: Int)

object JavaVersion {
  val versionRegex = """^JDK([1-9]\d*)u([1-9]\d*)$""".r

  def validate(str : String) : Boolean = {
    matchVersion(str) match {
      case Some(_) => true
      case None => false
    }
  }

  def parse(str : String) : JavaVersion = {
    val versionRegex(familyNumber, updateNumber) = str
    JavaVersion(familyNumber.toInt, updateNumber.toInt)
  }

  private[this] def matchVersion(str: String) : Option[String] = {
    versionRegex.findFirstIn(str)
  }
}
