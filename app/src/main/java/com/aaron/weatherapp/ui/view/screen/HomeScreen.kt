package com.aaron.weatherapp.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aaron.weatherapp.R
import com.aaron.weatherapp.state.WeatherScreenState
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.view.component.EmptyInformation
import com.aaron.weatherapp.ui.view.component.ErrorInformation
import com.aaron.weatherapp.ui.view.component.TopBar
import com.aaron.weatherapp.ui.view.component.WeatherInformation
import com.aaron.weatherapp.viewmodel.WeatherViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    weatherViewModel: WeatherViewModel = viewModel()
) {
    /* ==============================
    ========== VARIABLES ==========
    ============================== */
    // Mutable variables
    val searchText by weatherViewModel.searchText
    val screenState by weatherViewModel.screenState.collectAsState()


    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */

    // BACKGROUND
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.weather___home_2),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // LAYOUT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 48.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Search bar
            TopBar(
                text = searchText,
                onTextChange = {
                    weatherViewModel.onTextChange(it)
                },
                onButtonClick = {
                    weatherViewModel.fetchWeatherData()
                }
            )

            // Weather info and screen state handling
            when (screenState) {
                // Initialize
                is WeatherScreenState.Empty -> {
                    EmptyInformation(
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Found
                is WeatherScreenState.Found -> {
                    val data = (screenState as WeatherScreenState.Found).weather
                    if (data != null) {
                        WeatherInformation(
                            modifier = Modifier.fillMaxSize(),
                            weatherModel = data
                        )
                    }
                }

                // Not found
                is WeatherScreenState.NotFound -> {
                    ErrorInformation(
                        modifier = Modifier.fillMaxSize(),
                        errorMessage = (screenState as WeatherScreenState.NotFound).error
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    WeatherAppTheme {
        HomeScreen()
    }
}