package com.hizari.spaceflightnews.ui.screen.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hizari.spaceflightnews.R
import com.hizari.spaceflightnews.navigation.main.MainNavAction
import com.hizari.spaceflightnews.ui.component.main.Greeting
import com.hizari.spaceflightnews.ui.component.news.NewsSection
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import kotlinx.serialization.Serializable

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.feature.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Serializable
data object MainScreen

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    mainNavAction: (action: MainNavAction) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsState()

    MainScreenContent(
        modifier = modifier,
        doAction = viewModel::doAction,
        viewState = viewState
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreenContent() {
    SpaceflightNewsTheme {
        MainScreenContent(
            doAction = {},
            viewState = MainViewState()
        )
    }
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    doAction: (action: MainViewAction) -> Unit,
    viewState: MainViewState
) {
    LaunchedEffect(Unit) {
        doAction.invoke(MainViewAction.LoadArticleData)
        doAction.invoke(MainViewAction.LoadBlogData)
        doAction.invoke(MainViewAction.LoadReportData)
    }

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
            newsResource = viewState.articleNewsResource,
            onClickSeeMore = {},
            onRetry = { doAction.invoke(MainViewAction.LoadArticleData) },
            title = stringResource(R.string.article)
        )

        NewsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            newsResource = viewState.blogNewsResource,
            onClickSeeMore = {},
            onRetry = { doAction.invoke(MainViewAction.LoadBlogData) },
            title = stringResource(R.string.blog)
        )

        NewsSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            newsResource = viewState.reportNewsResource,
            onClickSeeMore = {},
            onRetry = { doAction.invoke(MainViewAction.LoadReportData) },
            title = stringResource(R.string.report)
        )

    }
}