package com.hizari.spaceflightnews.ui.screen.feature.main

import com.hizari.common.data.Resource
import com.hizari.domain.model.article.Article
import com.hizari.domain.model.blog.Blog
import com.hizari.domain.model.report.Report
import com.hizari.spaceflightnews.ui.component.news.News

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen.feature.main
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class MainViewState(
    var articleResources: Resource<List<Article>> = Resource.Loading,
    var blogResources: Resource<List<Blog>> = Resource.Loading,
    var reportResources: Resource<List<Report>> = Resource.Loading,
) {

    private fun <T> map(resource: Resource<List<T>>, transform: (T) -> News): Resource<List<News>> = when (resource) {
        is Resource.Success -> Resource.Success(resource.data.map(transform))
        is Resource.Error -> resource
        is Resource.Empty -> resource
        is Resource.Loading -> resource
    }

    val articleNewsResource: Resource<List<News>>
        get() = map(articleResources) { News.from(it) }

    val blogNewsResource: Resource<List<News>>
        get() = map(blogResources) { News.from(it) }

    val reportNewsResource: Resource<List<News>>
        get() = map(reportResources) { News.from(it) }
}