package com.hizari.spaceflightnews.navigation.main

/**
 * Spaceflight News - com.hizari.spaceflightnews.navigation.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

interface MainNavAction {
    data class GoBack(val result: Map<String, Any?>? = null) : MainNavAction
    data class GoToScreen(val destination: Any, val result: Map<String, Any>? = null) :
        MainNavAction
}