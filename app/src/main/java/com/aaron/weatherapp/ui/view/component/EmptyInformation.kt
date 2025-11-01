package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.weatherapp.R
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.theme.greyTransparent2

@Composable
fun EmptyInformation(
    modifier: Modifier = Modifier
) {
    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */

    // COLUMN LAYOUT
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        // Search Icon
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = greyTransparent2,
            modifier = Modifier
                .size(64.dp)
        )

        // Text Prompt
        Text (
            text = "Search for a city to get started",
            style = MaterialTheme.typography.bodyLarge,
            color = greyTransparent2
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EmptyInformationPreview() {
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
            EmptyInformation()
        }
    }
}