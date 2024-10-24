package com.hizari.spaceflightnews.navigation.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hizari.spaceflightnews.ui.component.navhost.SlideNavHost
import com.hizari.spaceflightnews.ui.screen.auth.login.LoginScreen
import com.hizari.spaceflightnews.ui.screen.auth.register.RegisterScreen
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.navigation.auth
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */



@Serializable
data object AuthNavigation

@Composable
fun AuthNavigation(modifier: Modifier = Modifier) {
    val authNavController = rememberNavController()

    fun authNavAction(action: AuthNavAction) {
        when (action) {
            is AuthNavAction.GoBack -> {
                action.result?.let { results ->
                    results.forEach { result ->
                        authNavController.previousBackStackEntry?.savedStateHandle?.set(
                            key = result.key,
                            value = result.value
                        )
                    }
                }
                authNavController.popBackStack()
            }

            is AuthNavAction.GoToScreen -> {
                authNavController.navigate(action.destination) {
                    restoreState = true
                    launchSingleTop = true
                }
            }
        }
    }

    SlideNavHost(
        modifier = modifier,
        navController = authNavController,
        startDestination = LoginScreen,
    ) {
        composable<LoginScreen> {
            LoginScreen(authNavAction = ::authNavAction)
        }
        composable<RegisterScreen> {
            RegisterScreen(authNavAction = ::authNavAction)
        }
    }
}