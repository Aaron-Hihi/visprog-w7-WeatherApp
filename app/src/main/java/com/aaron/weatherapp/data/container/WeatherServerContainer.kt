package com.aaron.weatherapp.data.container

import android.util.Log
import com.aaron.weatherapp.data.repository.WeatherRepository
import com.aaron.weatherapp.data.service.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherServerContainer {

    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        var ACCESS_TOKEN = "493b68fcccfb9598f119a2744e370c54"
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }

    val weatherServerRepostitory: WeatherRepository by lazy {
        WeatherRepository(retrofitService)
    }

}