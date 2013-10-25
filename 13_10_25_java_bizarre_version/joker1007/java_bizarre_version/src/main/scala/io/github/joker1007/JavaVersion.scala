package io.github.joker1007

case class JavaVersion(familyNumber: Int, updateNumber: Int) extends Ordered[JavaVersion] {
  def compare(that: JavaVersion) = {
    if (familyNumber == that.familyNumber)
      updateNumber - that.updateNumber
    else
      familyNumber - that. familyNumber
  }

  def nextLimitedUpdate : JavaVersion = {
    val temp = (updateNumber + 20)
    val newUpdateNumber = temp - (temp % 20)
    copy(updateNumber = newUpdateNumber)
  }

  def nextCriticalPatchUpdate : JavaVersion = {
    val temp = (updateNumber + 5)
    val newUpdateNumber = temp - (temp % 5)
    copy(updateNumber = if (newUpdateNumber % 2 == 0) newUpdateNumber + 1 else newUpdateNumber)
  }

  def nextSecurityAlert : JavaVersion = {
    copy(updateNumber = updateNumber + 1)
  }
}

object JavaVersion {
  val versionRegex = """^JDK([1-9]\d*)u([1-9]\d*)$""".r

  def validate(str : String) : Boolean = {
    matchVersion(str) match {
      case Some(_) => true
      case None => false
    }
  }

  def parse(str : String) : Option[JavaVersion] = {
    for {
      versionRegex(familyNumber, updateNumber) <- matchVersion(str)
    } yield JavaVersion(familyNumber.toInt, updateNumber.toInt)
  }

  private[this] def matchVersion(str: String) : Option[String] = {
    versionRegex.findFirstIn(str)
  }
}
