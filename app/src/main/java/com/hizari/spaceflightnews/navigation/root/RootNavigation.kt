package com.hizari.spaceflightnews.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.hizari.spaceflightnews.navigation.auth.AuthNavigation
import com.hizari.spaceflightnews.navigation.main.MainNavigation
import com.hizari.spaceflightnews.ui.component.navhost.SlideNavHost

/**
 * Spaceflight News - com.hizari.spaceflightnews.navigation.root
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Composable
fun RootNavigation(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    userLoggedIn: Boolean,
) {
    SlideNavHost(
        modifier = modifier,
        navController = rootNavController,
        startDestination = if (userLoggedIn.not()) AuthNavigation else MainNavigation
    ) {

        composable<AuthNavigation> {
            AuthNavigation()
        }
        composable<MainNavigation> {
            MainNavigation()
        }
    }
}