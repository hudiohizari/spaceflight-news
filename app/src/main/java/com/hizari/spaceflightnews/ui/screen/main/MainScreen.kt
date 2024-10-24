package com.hizari.spaceflightnews.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hizari.spaceflightnews.R
import com.hizari.spaceflightnews.navigation.main.MainNavAction
import com.hizari.spaceflightnews.ui.component.main.Greeting
import com.hizari.spaceflightnews.ui.component.news.News
import com.hizari.spaceflightnews.ui.component.news.NewsSection
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Serializable
data object MainScreen

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    SpaceflightNewsTheme {
        MainScreen(
            mainNavAction = {}
        )
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainNavAction: (action: MainNavAction) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {

        Greeting(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = 16.dp,
                    start = 16.dp,
                    top = 16.dp,
                ),
            name = "User Name",
        )

        NewsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            newsList = listOf(
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
            ),
            onClickSeeMore = {},
            title = stringResource(R.string.article)
        )

        NewsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            newsList = listOf(
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
            ),
            onClickSeeMore = {},
            title = stringResource(R.string.blog)
        )

        NewsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            newsList = listOf(
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
                News.dummy,
            ),
            onClickSeeMore = {},
            title = stringResource(R.string.report)
        )

    }
}