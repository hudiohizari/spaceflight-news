package com.hizari.spaceflightnews.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hizari.spaceflightnews.R
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
        in 0..11 -> stringResource(R.string.good_morning)
        in 12..15 -> stringResource(R.string.good_afternoon)
        in 16..19 -> stringResource(R.string.good_evening)
        else -> stringResource(R.string.good_night)
    }
    Text(
        modifier = modifier,
        text = "$greeting\n$name",
        textAlign = TextAlign.Center
    )
}