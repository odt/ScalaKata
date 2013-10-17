package io.github.joker1007

sealed trait WebData {
  val key : String
  val targetDifference : Int
}

case class WeatherData(day : String, maxTemp : Int, minTemp : Int) extends WebData {
  lazy val temperatureSpread : Int = maxTemp - minTemp

  lazy val key : String = day
  lazy val targetDifference : Int = temperatureSpread
}

case class FootballData(team : String, forGoal : Int, againstGoal : Int) extends WebData {
  lazy val forAgainstDifference : Int = Math.abs(forGoal - againstGoal)

  lazy val key : String = team
  lazy val targetDifference : Int = forAgainstDifference
}