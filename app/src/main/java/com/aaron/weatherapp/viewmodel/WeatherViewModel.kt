package com.aaron.weatherapp.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaron.weatherapp.data.container.WeatherServerContainer
import com.aaron.weatherapp.model.WeatherModel
import com.aaron.weatherapp.state.WeatherScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    /* ==============================
    ========= GETTER SETTER =========
    ============================== */
    // Screen state (empty, found, not found)
    private val _screenState = MutableStateFlow<WeatherScreenState>(WeatherScreenState.Empty)
    val screenState: StateFlow<WeatherScreenState> = _screenState

    // Search text
    var searchText = mutableStateOf("")

    // Weather data
    private val _weatherData = MutableStateFlow<WeatherModel?>(null)
    val weatherData: StateFlow<WeatherModel?> = _weatherData



    /* ==============================
    ============== INIT =============
    ============================== */
    private val weatherServerContainer = WeatherServerContainer()


    /* ==============================
    =========== FUNCTIONS ===========
    ============================== */
    // Screen state
    fun onTextChange(newText: String) {
        //Log.d("WeatherVM", "onTextChange function reached")
        searchText.value = newText
    }

    // Weather Data
    fun fetchWeatherData() {
        //Log.d("WeatherVM", "fetch function reached")
        val cityName = searchText.value.trim()

        // If search value is empty, then return
        if (cityName.isEmpty()) {
            _screenState.value = WeatherScreenState.Empty
            return
        }

        // Logic
        viewModelScope.launch {
            // If found, update screen state and weather data
            try {
                Log.d("WeatherVM", "Fetching weather data for $cityName")
                val repository = weatherServerContainer.weatherServerRepostitory
                val result = repository.getWeather(cityName)
                _weatherData.value = result
                _screenState.value = WeatherScreenState.Found(_weatherData.value)
            }

            // If not, get not found screen
            catch (e: Exception) {
                e.printStackTrace()
                _screenState.value = WeatherScreenState.NotFound("HTTP 404 Not Found")
            }
        }
    }


}