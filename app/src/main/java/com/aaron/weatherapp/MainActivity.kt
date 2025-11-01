package com.aaron.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.view.screen.HomeScreen
import com.aaron.weatherapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            WeatherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    // Init viewmodels
                    val viewModel: WeatherViewModel = viewModel()
                    HomeScreen(weatherViewModel = viewModel)
                }
            }
        }
    }
}