package com.aaron.weatherapp.model


data class WeatherModel (
    val cityName: String,
    val cityDate: String,
    val updateTime: String,
    val weatherId: Int,
    val weatherIcon: String,
    val weatherDescription: String,
    val temperature: Int,               // celcius
    val humidity: Int,                  // %
    val windSpeed: Int,                 // km/h
    val feelsLike: Int,                 // celcius
    val rainFall: Double,               // mm
    val pressure: Int,                  // hPa
    val clouds: Int,                    // %
    val sunriseTime: String,
    val sunsetTime: String
)