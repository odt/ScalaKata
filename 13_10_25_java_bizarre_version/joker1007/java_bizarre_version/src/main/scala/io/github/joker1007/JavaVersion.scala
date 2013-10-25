package io.github.joker1007


object JavaVersion {
  val versionRegex = """JDK\du\d\d""".r

  def validate(str : String) : Boolean = {
    versionRegex findFirstIn str match {
      case Some(_) => true
      case None => false
    }
  }
}
