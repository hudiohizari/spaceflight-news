package com.hizari.spaceflightnews.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import java.util.Calendar

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.component
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    SpaceflightNewsTheme {
        Box {
            Greeting(name = "Android")
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    name: String
) {
    val currentHour = remember { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) }

    val greeting = when (currentHour) {
        in 0..11 -> "Good Morning"
        in 12..17 -> "Good Evening"
        else -> "Good Night"
    }
    Text(
        modifier = modifier,
        text = "$greeting\n$name",
        textAlign = TextAlign.Center
    )
}