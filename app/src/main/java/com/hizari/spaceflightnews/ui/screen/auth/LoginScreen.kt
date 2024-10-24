package com.hizari.spaceflightnews.ui.screen.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hizari.spaceflightnews.navigation.auth.AuthNavAction
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.auth
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Serializable
data object LoginScreen

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    SpaceflightNewsTheme {
        LoginScreen(
            modifier = Modifier,
            authNavAction = {}
        )
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    authNavAction: (action: AuthNavAction) -> Unit,
) {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "Login Screen"
    )
}