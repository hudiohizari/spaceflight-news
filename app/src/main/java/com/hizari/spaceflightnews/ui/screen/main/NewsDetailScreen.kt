package com.hizari.spaceflightnews.ui.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Preview(showBackground = true)
@Composable
fun PreviewNewsDetailScreen() {
    SpaceflightNewsTheme {
        NewsDetailScreen()
    }
}

@Composable
fun NewsDetailScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "News Detail Screen"
    )
}