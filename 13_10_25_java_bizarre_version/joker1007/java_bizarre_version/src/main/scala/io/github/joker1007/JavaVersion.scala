package io.github.joker1007


object JavaVersion {
  val versionRegex = """^JDK([1-9])\d*u([1-9])\d*$""".r

  def validate(str : String) : Boolean = {
    versionRegex findFirstIn str match {
      case Some(_) => true
      case None => false
    }
  }
}
