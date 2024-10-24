package com.hizari.spaceflightnews.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hizari.spaceflightnews.ui.component.navhost.SlideNavHost
import com.hizari.spaceflightnews.ui.screen.main.MainScreen
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.navigation.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Serializable
data object MainNavigation

@Composable
fun MainNavigation(modifier: Modifier = Modifier) {
    val mainNavController = rememberNavController()

    fun mainNavAction(action: MainNavAction) {
        when (action) {
            is MainNavAction.GoBack -> {
                action.result?.let { results ->
                    results.forEach { result ->
                        mainNavController.previousBackStackEntry?.savedStateHandle?.set(
                            key = result.key,
                            value = result.value
                        )
                    }
                }
                mainNavController.popBackStack()
            }

            is MainNavAction.GoToScreen -> {
                mainNavController.navigate(action.destination) {
                    restoreState = true
                    launchSingleTop = true
                }
            }
        }
    }

    SlideNavHost(
        modifier = modifier,
        navController = mainNavController,
        startDestination = MainScreen,
    ) {
        composable<MainScreen> {
            MainScreen(mainNavAction = ::mainNavAction)
        }
    }
}