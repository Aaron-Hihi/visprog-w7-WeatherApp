package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.aaron.weatherapp.R
import com.aaron.weatherapp.model.WeatherModel

@Composable
fun PandaImage(
    modifier: Modifier = Modifier,
    weatherModel: WeatherModel
) {
    val backgroundRes = when (weatherModel.weatherId) {
        // Clear
        800 -> R.drawable.blue_and_black_bold_typography_quote_poster_3

        // Cloudy
        in 801..804 -> R.drawable.blue_and_black_bold_typography_quote_poster

        // Rainy (or thunder or drizzle)
        in 500..531, in 300..321, in 200..232 -> R.drawable.blue_and_black_bold_typography_quote_poster_2

        // Default
        else -> R.drawable.blue_and_black_bold_typography_quote_poster
    }

    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = backgroundRes),
            contentDescription = null
        )
    }
}