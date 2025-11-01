package com.aaron.weatherapp.data.dummy

import com.aaron.weatherapp.model.WeatherModel

object DummyWeatherInformation {
    val dummyWeather = WeatherModel(
        cityName = "London",
        cityDate = "September 24",
        updateTime = "10:00 AM",
        weatherId = 800,
        weatherIcon = "10d",
        weatherDescription = "Light rain",
        temperature = 18,
        humidity = 82,
        windSpeed = 5,
        feelsLike = 17,
        rainFall = 0.8,
        pressure = 1012,
        clouds = 75,
        sunriseTime = "5:22 AM",
        sunsetTime = "5:29 PM"
    )
}