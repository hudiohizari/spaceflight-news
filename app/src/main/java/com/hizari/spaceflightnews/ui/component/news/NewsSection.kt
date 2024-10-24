package com.hizari.spaceflightnews.ui.component.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.hizari.spaceflightnews.R
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.component.news
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

data class News(
    val id: String,
    val title: String,
    val imageUrl: String,
) {

    companion object {
        val dummy = News(
            id = "1",
            title = "Title",
            imageUrl = "https://picsum.photos/200/300"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsSection() {
    SpaceflightNewsTheme {
        Column {
            NewsSection(
                newsList = listOf(News.dummy),
                title = "Title",
                onClickSeeMore = {}
            )
        }
    }
}

@Composable
fun NewsSection(
    modifier: Modifier = Modifier,
    contentPadding: Int = 16,
    newsList: List<News>,
    onClickSeeMore: () -> Unit,
    textPadding: Int = 16,
    title: String,
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (tTitle, tSeeMore, lrNews) = createRefs()

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

        LazyRow(
            modifier = Modifier.constrainAs(lrNews) {
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
            items(newsList) { news ->
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
            text = news.title,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}