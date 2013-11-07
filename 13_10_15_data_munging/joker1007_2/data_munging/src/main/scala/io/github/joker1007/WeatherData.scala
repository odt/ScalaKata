package io.github.joker1007

case class WeatherData(maximumTemperature: Int, minimumTemperature: Int) {
  lazy val temperatureSpread = maximumTemperature - minimumTemperature
}
