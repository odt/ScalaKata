package io.github.joker1007

case class WeatherData(day : String, maxTemp : Int, minTemp : Int) {
  def temperatureSpread : Int = maxTemp - minTemp
}
