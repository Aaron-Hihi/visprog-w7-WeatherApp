package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.weatherapp.R
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.theme.greyTransparent
import com.aaron.weatherapp.ui.theme.greyTransparent2

@Composable
fun WeatherDataCard(
    modifier: Modifier = Modifier,
    cardIcon: Painter,
    cardTitle: String,
    cardValue: String,
    containerColor: Color = greyTransparent
) {
    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */

    // ROW LAYOUT
    Card (
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {

        // Col Layout
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icon
            Image(
                painter = cardIcon,
                contentDescription = "Icon",
                modifier = Modifier.size(24.dp)
            )

            // Title
            Text(
                text = cardTitle.uppercase(),
                style = MaterialTheme.typography.bodyMedium,
                color = greyTransparent2
            )

            // Value
            Text(
                text = cardValue,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherDataCardPreview() {
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
            WeatherDataCard(
                modifier = Modifier,
                cardIcon = painterResource(id = R.drawable.icon_humidity),
                cardTitle = "Humidity",
                cardValue = "80%"
            )
        }
    }
}