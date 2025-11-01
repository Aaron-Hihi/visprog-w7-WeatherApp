package com.aaron.weatherapp.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.aaron.weatherapp.data.container.WeatherServerContainer
import com.aaron.weatherapp.data.service.WeatherService
import com.aaron.weatherapp.model.WeatherModel
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class WeatherRepository(
    private val service: WeatherService
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getWeather(cityName: String): WeatherModel {
        try {
            // Calling Weather Data
            val weatherRaw = service.getWeather(
                cityName,
                WeatherServerContainer.ACCESS_TOKEN,
                "metric",
            )

            // Error handling
            if (weatherRaw.weather.isNullOrEmpty()) {
                throw Exception()
            }

            // Datetime Adjusting
            val updateInstant = Instant.ofEpochSecond(weatherRaw.dt.toLong())
            val myTimeZone = ZoneId.systemDefault()
            val cityTimeZoneOffset = weatherRaw.timezone
            val cityTimeZone = ZoneOffset.ofTotalSeconds(cityTimeZoneOffset)

            // Creating Weather Model
            val weatherModel = WeatherModel(
                // Base infos
                cityName = weatherRaw.name,
                weatherId = weatherRaw.weather[0].id,
                weatherIcon = weatherRaw.weather[0].icon,
                weatherDescription = weatherRaw.weather[0].description,

                // Times
                cityDate = updateInstant.atZone(cityTimeZone)
                    .toLocalDate()
                    .format(DateTimeFormatter.ofPattern("MMMM d")),
                updateTime = updateInstant.atZone(myTimeZone)
                    .toLocalTime()
                    .format(DateTimeFormatter.ofPattern("HH:mm")),
                sunriseTime = Instant.ofEpochSecond(weatherRaw.sys.sunrise.toLong())
                    .atZone(cityTimeZone)
                    .toLocalTime()
                    .format(DateTimeFormatter.ofPattern("h:mm a")),
                sunsetTime = Instant.ofEpochSecond(weatherRaw.sys.sunset.toLong())
                    .atZone(cityTimeZone)
                    .toLocalTime()
                    .format(DateTimeFormatter.ofPattern("h:mm a")),

                // Weather datas
                temperature = weatherRaw.main.temp.toInt(),
                humidity = weatherRaw.main.humidity,
                feelsLike = weatherRaw.main.feels_like.toInt(),
                rainFall = weatherRaw.rain?.`1h` ?: 0.0,
                pressure = weatherRaw.main.pressure,
                clouds = weatherRaw.clouds.all,

                // m/s to km/h (x * 3600s / 1000m)
                windSpeed = (weatherRaw.wind.speed * 3.6).toInt()
            )

            return weatherModel
        }

        catch (e: Exception) {
            throw Exception()
        }
    }
}

/*
JSON
{
    "coord": {
        "lon": 112.7508,
        "lat": -7.2492
    },
    "weather": [
        {
            "id": 802,
            "main": "Clouds",
            "description": "scattered clouds",
            "icon": "03n"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 299.27,
        "feels_like": 299.27,
        "temp_min": 299.27,
        "temp_max": 300.12,
        "pressure": 1011,
        "humidity": 92,
        "sea_level": 1011,
        "grnd_level": 1010
    },
    "visibility": 5000,
    "wind": {
        "speed": 1.03,
        "deg": 0
    },
    "clouds": {
        "all": 40
    },
    "dt": 1761939498, (Update Time)
    "sys": {
        "type": 2,
        "id": 2081990,
        "country": "ID",
        "sunrise": 1761948095,
        "sunset": 1761992607
    },
    "timezone": 25200,
    "id": 1625822,
    "name": "Surabaya",
    "cod": 200
}

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
 */