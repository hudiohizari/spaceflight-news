package com.hizari.spaceflightnews.ui.screen.auth.register

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hizari.spaceflightnews.navigation.auth.AuthNavAction
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.auth.register
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Serializable
data object RegisterScreen

@Preview(showBackground = true)
@Composable
fun PreviewRegisterScreen() {
    SpaceflightNewsTheme {
        RegisterScreen(
            modifier = Modifier,
            authNavAction = {}
        )
    }
}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    authNavAction: (action: AuthNavAction) -> Unit,
) {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "Register Screen"
    )
}