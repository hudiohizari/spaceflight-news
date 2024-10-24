package com.hizari.spaceflightnews.ui.screen.feature.main

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.feature.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

sealed interface MainViewAction {
    data object LoadArticleData : MainViewAction
    data object LoadBlogData : MainViewAction
    data object LoadReportData : MainViewAction
}