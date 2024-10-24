package com.hizari.spaceflightnews.ui.component.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme
import com.hizari.spaceflightnews.ui.theme.Typography

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.component.button
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Preview
@Composable
private fun PreviewSNButton() {
    SpaceflightNewsTheme {
        Column {
            SNButton(
                text = "Button",
                enabled = true,
                loading = true,
                onClick = { }
            )
            Spacer(modifier = Modifier.size(8.dp))
            SNButton(
                text = "Button",
                enabled = false,
                loading = true,
                onClick = { }
            )
            Spacer(modifier = Modifier.size(8.dp))
            SNButton(
                text = "Button",
                enabled = true,
                loading = false,
                onClick = { }
            )
            Spacer(modifier = Modifier.size(8.dp))
            SNButton(
                text = "Button",
                enabled = false,
                loading = false,
                onClick = { }
            )
        }
    }
}

@Composable
fun SNButton(
    modifier: Modifier = Modifier,
    text: String,
    loading: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    val enabledValue = enabled && loading.not()

    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = MaterialTheme.colorScheme.tertiary
        ),
        enabled = enabledValue,
        onClick = { if (enabledValue) onClick.invoke() },
        shape = RoundedCornerShape(8.dp),
    ) {
        AnimatedVisibility(loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = MaterialTheme.colorScheme.surface,
            )
        }
        AnimatedVisibility(loading.not()) {
            Text(
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = text,
                style = Typography.bodyMedium
            )
        }
    }
}