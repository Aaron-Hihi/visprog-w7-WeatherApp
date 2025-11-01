package com.aaron.weatherapp.data.service

import com.aaron.weatherapp.data.dto.ResponseWeather
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    // Read data from cityName
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): ResponseWeather
}