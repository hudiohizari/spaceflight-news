package com.hizari.spaceflightnews.ui.component.state

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.hizari.spaceflightnews.R
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import com.hizari.spaceflightnews.ui.theme.Typography

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.component.state
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Preview
@Composable
private fun PreviewDefaultEmpty() {
    SpaceflightNewsTheme {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.surface),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            DefaultEmpty()
            DefaultEmpty(
                imageVector = Icons.Default.Clear,
                message = "Empty"
            )
            DefaultEmpty(
                imageVector = Icons.Default.Block,
                message = "Non Existent"
            )
            DefaultEmpty(
                message = "This is Empty",
                description = "Much very empty this is"
            )
        }
    }
}

@Composable
fun DefaultEmpty(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Default.Inbox,
    message: String = LocalContext.current.getString(R.string.empty_data),
    description: String? = null,
    messageColor: Color = MaterialTheme.colorScheme.onSurface,
    descriptionColor: Color = MaterialTheme.colorScheme.tertiary,
) {

    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        val (iEmpty, tEmptyMessage, tEmptyDescription) = createRefs()

        Icon(
            imageVector = imageVector,
            contentDescription = message,
            modifier = Modifier
                .constrainAs(iEmpty) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    height = Dimension.ratio("H, 2.5:3")
                    width = Dimension.preferredValue(96.dp)
                },
        )

        Text(
            color = messageColor,
            modifier = Modifier
                .constrainAs(tEmptyMessage) {
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(iEmpty.bottom, 12.dp)
                    width = Dimension.fillToConstraints
                },
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = Typography.bodyLarge,
            text = message,
            textAlign = TextAlign.Center,
        )

        if (description.isNullOrEmpty().not()) {
            Text(
                color = descriptionColor,
                modifier = Modifier
                    .constrainAs(tEmptyDescription) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        top.linkTo(tEmptyMessage.bottom, 8.dp)
                        width = Dimension.fillToConstraints
                    },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = Typography.bodyMedium,
                text = description.orEmpty(),
                textAlign = TextAlign.Center
            )
        }
    }
}