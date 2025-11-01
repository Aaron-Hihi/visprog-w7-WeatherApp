package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.weatherapp.R
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.theme.greyTransparent2
import com.aaron.weatherapp.ui.theme.white

@Composable
fun ErrorInformation(
    modifier: Modifier = Modifier,
    errorMessage: String = "An unknown error occurred"
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

        // Warning Icon
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Warning",
            tint = Color.Red,
            modifier = Modifier
                .size(64.dp)
        )

        // Text Prompt
        Text (
            text = "Oops! Something went wrong",
            style = MaterialTheme.typography.titleLarge,
            color = white
        )

        // Error message
        Text (
            text = errorMessage,
            style = MaterialTheme.typography.bodyLarge,
            color = greyTransparent2
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ErrorInformationPreview() {
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
            ErrorInformation()
        }
    }
}