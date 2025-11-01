package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.weatherapp.R
import com.aaron.weatherapp.data.dummy.DummyWeatherInformation
import com.aaron.weatherapp.model.WeatherModel
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.theme.greyTransparent2
import com.aaron.weatherapp.ui.theme.white

@Composable
fun WeatherInformation(
    modifier: Modifier = Modifier,
    weatherModel: WeatherModel
) {
    /* ==============================
    ========== VARIABLES ==========
    ============================== */
    // Mutable variables
    

    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */

    // COLUMN LAYOUT
    LazyColumn (
        modifier = modifier,
        verticalArrangement = Arrangement
            .spacedBy(
                space = 128.dp,
                alignment = Alignment.Top
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // SECTION 1: GENERAL CITY INFORMATION
        item {
            Column(
                verticalArrangement = Arrangement
                    .spacedBy(
                        space = 10.dp,
                        alignment = Alignment.Top
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // ROW LAYOUT
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Location Icon
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = white
                    )

                    // Name of city
                    Text(
                        text = weatherModel.cityName,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                // City date
                Text(
                    text = "${weatherModel.cityDate}",
                    style = MaterialTheme.typography.headlineMedium
                )

                // Updated as of
                Text(
                    text = "Updated as of ${weatherModel.updateTime}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = greyTransparent2
                )
            }
        }

        // SECTION 2: WEATHER INFORMATION
        // ROW LAYOUT

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Weather Info
                Column(
                    modifier = Modifier
                        .weight(0.5f),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Weather icon
                    WeatherIcon(weatherIcon = weatherModel.weatherIcon)

                    // Space between weather icon and text
                    Spacer(
                        modifier = Modifier
                            .height(4.dp)
                    )

                    // Weather Description
                    Text(
                        text = weatherModel.weatherDescription.capitalize(),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )


                    // Weather Temperature
                    Text(
                        text = "${weatherModel.temperature}°C",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }

                // Panda Image
                PandaImage(
                    weatherModel = weatherModel,
                    modifier = Modifier
                        .weight(0.5f)
                )
            }
        }

        // SECTION 3: GRID DATA
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically,
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Row 1: Humidity, wind, feels like
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // HUMIDITY CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.icon_humidity),
                        cardTitle = "Humidity",
                        cardValue = "${weatherModel.humidity}%"
                    )

                    // WIND CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.icon_wind),
                        cardTitle = "Wind",
                        cardValue = "${weatherModel.windSpeed}km/h"
                    )

                    // FEELS LIKE CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.icon_feels_like),
                        cardTitle = "Feels Like",
                        cardValue = "${weatherModel.feelsLike}°"
                    )
                }

                // Row 2: Rain fall, pressure, clouds
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // HUMIDITY CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.vector_2),
                        cardTitle = "Rain Fall",
                        cardValue = "${weatherModel.rainFall} mm"
                    )

                    // WIND CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.devices),
                        cardTitle = "Wind",
                        cardValue = "${weatherModel.pressure}hPa"
                    )

                    // FEELS LIKE CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.cloud),
                        cardTitle = "Clouds",
                        cardValue = "${weatherModel.clouds}%"
                    )
                }

                // ROW 3: Sunrise and Sunset
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // SUNRISE CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.vector),
                        cardTitle = "Sunrise",
                        cardValue = weatherModel.sunriseTime,
                        containerColor = Color.Transparent
                    )

                    // SUNSET CARD
                    WeatherDataCard(
                        modifier = Modifier.weight(1f),
                        cardIcon = painterResource(id = R.drawable.vector_21png),
                        cardTitle = "Sunset",
                        cardValue = weatherModel.sunsetTime,
                        containerColor = Color.Transparent
                    )
                }

            }
        }

    }





}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherInformationPreview() {
    WeatherAppTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            // BG
            Image(
                painter = painterResource(id = R.drawable.weather___home_2),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Info
            WeatherInformation(
                modifier = Modifier.fillMaxSize(),
                weatherModel = DummyWeatherInformation.dummyWeather
            )
        }
    }
}