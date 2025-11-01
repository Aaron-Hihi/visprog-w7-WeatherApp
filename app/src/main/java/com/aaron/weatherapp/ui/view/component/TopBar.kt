package com.aaron.weatherapp.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.weatherapp.ui.theme.WeatherAppTheme
import com.aaron.weatherapp.ui.theme.greyTransparent
import com.aaron.weatherapp.ui.theme.greyTransparent2
import com.aaron.weatherapp.ui.theme.white

@Composable
fun TopBar(modifier: Modifier = Modifier,
           text: String,
           onTextChange: (String) -> Unit,
           onButtonClick: () -> Unit
) {
    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */
    Row (
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
             space = 16.dp,
             alignment = Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            // Value and behavior
            value = text,
            textStyle = MaterialTheme.typography.bodyMedium,
            onValueChange = onTextChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.66f)
                .height(64.dp),

            // Decorations
            placeholder = {
                Text(
                    text = "Enter city name...",
                    style = MaterialTheme.typography.bodyMedium,
                    color = greyTransparent2
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    tint = Color.White
                )
            },

            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = greyTransparent,
                unfocusedContainerColor = greyTransparent,
                focusedIndicatorColor = greyTransparent2,
                unfocusedIndicatorColor = greyTransparent2,
                focusedTextColor = white,
                unfocusedTextColor = white,
                cursorColor = white
            )
        )

        // Button
        Button (
            onClick = onButtonClick,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = greyTransparent2,
                    shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = greyTransparent,
                contentColor = white
            ),
            contentPadding = PaddingValues(0.dp)
        ) {
            // Put space between Icon and Text
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Search Icon
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = white
                )

                // Search text
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }





}




@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    WeatherAppTheme {
        Box(
            modifier = Modifier.background(
                color = Color.Blue
            )
        ) {
            TopBar(Modifier, "Surabaya", {}, {})
        }
    }
}