package com.hizari.spaceflightnews.ui.component.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.hizari.common.data.Resource
import com.hizari.common.util.SNLog
import com.hizari.domain.model.article.Article
import com.hizari.domain.model.blog.Blog
import com.hizari.domain.model.report.Report
import com.hizari.spaceflightnews.R
import com.hizari.spaceflightnews.ui.component.state.DefaultEmpty
import com.hizari.spaceflightnews.ui.component.state.DefaultError
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import com.hizari.spaceflightnews.ui.theme.Typography

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.component.news
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class News(
    val id: Int,
    val title: String,
    val imageUrl: String,
) {

    companion object {
        val dummy = News(
            id = 1,
            title = "Title",
            imageUrl = "https://picsum.photos/200/300"
        )

        fun from(article: Article): News {
            return News(
                id = article.id,
                title = article.title,
                imageUrl = article.imageUrl
            )
        }

        fun from(blog: Blog): News {
            return News(
                id = blog.id,
                title = blog.title,
                imageUrl = blog.imageUrl
            )
        }

        fun from(report: Report): News {
            return News(
                id = report.id,
                title = report.title,
                imageUrl = report.imageUrl
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsSection() {
    SpaceflightNewsTheme {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            NewsSection(
                newsResource = Resource.Loading,
                title = "Title",
                onClickSeeMore = {},
                onRetry = {},
            )
            NewsSection(
                newsResource = Resource.Success(listOf(News.dummy)),
                title = "Title",
                onClickSeeMore = {},
                onRetry = {},
            )
            NewsSection(
                newsResource = Resource.Error(500, "Error"),
                title = "Title",
                onClickSeeMore = {},
                onRetry = {},
            )
        }
    }
}

@Composable
fun NewsSection(
    modifier: Modifier = Modifier,
    contentPadding: Int = 16,
    newsResource: Resource<List<News>>,
    onClickSeeMore: () -> Unit,
    onRetry: (() -> Unit),
    textPadding: Int = 16,
    title: String,
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (tTitle, tSeeMore, vNews) = createRefs()

        Text(
            modifier = Modifier.constrainAs(tTitle) {
                end.linkTo(tSeeMore.start, 16.dp)
                start.linkTo(parent.start, textPadding.dp)
                top.linkTo(parent.top)
                width = Dimension.fillToConstraints
            },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = title,
        )

        Text(modifier = Modifier
            .constrainAs(tSeeMore) {
                end.linkTo(parent.end, textPadding.dp)
                top.linkTo(parent.top)
            }
            .clickable(onClick = onClickSeeMore), text = stringResource(R.string.see_more))

        when (newsResource) {
            is Resource.Loading -> {
                Box(
                    modifier = Modifier.constrainAs(vNews) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        top.linkTo(tTitle.bottom, 12.dp)
                        height = Dimension.value(120.dp)
                        width = Dimension.fillToConstraints
                    },
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            is Resource.Success -> {
                val list = newsResource.data
                if (list.isEmpty()) {
                    DefaultEmpty(
                        modifier = Modifier.constrainAs(vNews) {
                            end.linkTo(parent.end)
                            start.linkTo(parent.start)
                            top.linkTo(tTitle.bottom, 12.dp)
                            height = Dimension.value(120.dp)
                            width = Dimension.fillToConstraints
                        }
                    )
                } else {
                    LazyRow(
                        modifier = Modifier.constrainAs(vNews) {
                            end.linkTo(parent.end)
                            start.linkTo(parent.start)
                            top.linkTo(tTitle.bottom, 12.dp)
                            height = Dimension.value(120.dp)
                            width = Dimension.fillToConstraints
                        },
                        contentPadding = PaddingValues(
                            horizontal = contentPadding.dp,
                        ),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        items(list) { news ->
                            NewsItem(
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .fillMaxHeight(),
                                news = news,
                                onClick = {}
                            )
                        }
                    }
                }
            }

            is Resource.Error -> {
                DefaultError(
                    modifier = Modifier.constrainAs(vNews) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        top.linkTo(tTitle.bottom, 12.dp)
                        height = Dimension.value(120.dp)
                        width = Dimension.fillToConstraints
                    },
                    message = newsResource.asMessage(),
                    onRetry = onRetry
                )
            }

            else -> SNLog.i("Unhandled state = ${newsResource.javaClass.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsItem() {
    SpaceflightNewsTheme {
        Row(
            modifier = Modifier
                .height(120.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            NewsItem(
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxHeight(),
                news = News.dummy,
                onClick = {}
            )
            NewsItem(
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxHeight(),
                news = News.dummy,
                onClick = {}
            )
        }
    }
}

@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    news: News,
    onClick: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        val (aiBanner, tTitle) = createRefs()

        AsyncImage(
            modifier = Modifier.constrainAs(aiBanner) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                height = Dimension.fillToConstraints
                width = Dimension.fillToConstraints
            },
            model = news.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_image_placeholder),
            error = painterResource(R.drawable.ic_broken_image),
        )

        Text(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
                .constrainAs(tTitle) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    width = Dimension.fillToConstraints
                },
            color = MaterialTheme.colorScheme.onSurface,
            text = news.title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = Typography.labelSmall,
        )
    }
}