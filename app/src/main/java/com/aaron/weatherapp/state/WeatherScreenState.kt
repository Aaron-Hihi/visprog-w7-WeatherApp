package com.aaron.weatherapp.state

import com.aaron.weatherapp.model.WeatherModel

sealed class WeatherScreenState {
    object Empty: WeatherScreenState()
    data class Found(val weather: WeatherModel?): WeatherScreenState()
    data class NotFound(val error: String): WeatherScreenState()
}