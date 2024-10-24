package com.hizari.spaceflightnews.ui.screen.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hizari.common.data.Resource
import com.hizari.common.util.SNLog
import com.hizari.domain.usecase.article.GetArticleListUseCase
import com.hizari.domain.usecase.blog.GetBlogListUseCase
import com.hizari.domain.usecase.report.GetReportListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.feature.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val getBlogListUseCase: GetBlogListUseCase,
    private val getReportListUseCase: GetReportListUseCase,
): ViewModel() {

    private val mutableViewState = MutableStateFlow(MainViewState())
    val viewState = mutableViewState.asStateFlow()

    fun updateViewState(update: (MainViewState) -> MainViewState) {
        mutableViewState.update(update)
    }

    fun doAction(action: MainViewAction) {
        when (action) {
            MainViewAction.LoadArticleData -> loadArticleList()
            MainViewAction.LoadBlogData -> loadBlogList()
            MainViewAction.LoadReportData -> loadReportList()
        }
    }

    private fun loadArticleList(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ) {
        getArticleListUseCase(
            newsSite = newsSite,
            limit = limit,
            offset = offset,
            search = search
        ).onEach { res ->
            updateViewState {
                it.copy(
                    articleResources = res
                )
            }
        }.launchIn(viewModelScope)
    }


    private fun loadBlogList(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ) {
        getBlogListUseCase(
            newsSite = newsSite,
            limit = limit,
            offset = offset,
            search = search
        ).onEach { res ->
            updateViewState {
                it.copy(
                    blogResources = res
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun loadReportList(
        newsSite: String? = null,
        limit: Int = 10,
        offset: Int = 10,
        search: String? = null,
    ) {
        getReportListUseCase(
            newsSite = newsSite,
            limit = limit,
            offset = offset,
            search = search
        ).onEach { res ->
            updateViewState {
                it.copy(
                    reportResources = res
                )
            }
        }.launchIn(viewModelScope)
    }

}