package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WeatherIcon(
    modifier: Modifier = Modifier,
    weatherIcon: String
) {

    // Weather Icon
    AsyncImage(
        model = "https://openweathermap.org/img/wn/$weatherIcon@2x.png",
        contentDescription = "Weather Icon",
        modifier = modifier
            .size(64.dp)
            //.border(1.dp, Color.Red)
    )
}
