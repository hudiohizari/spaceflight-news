package com.hizari.spaceflightnews.navigation.auth


/**
 * Spaceflight News - com.hizari.spaceflightnews.navigation.auth
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

interface AuthNavAction {
    data class GoBack(val result: Map<String, Any?>? = null) : AuthNavAction
    data class GoToScreen(val destination: Any, val result: Map<String, Any>? = null) :
        AuthNavAction
}