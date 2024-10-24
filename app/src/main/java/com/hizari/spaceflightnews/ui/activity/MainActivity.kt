package com.hizari.spaceflightnews.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.hizari.spaceflightnews.navigation.root.RootNavigation
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.activity
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val rootNavController = rememberNavController()

            SpaceflightNewsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootNavigation(
                        modifier = Modifier.padding(paddingValues = innerPadding),
                        rootNavController = rootNavController,
                        userLoggedIn = true,
                    )
                }
            }
        }
    }
}