package com.hizari.spaceflightnews.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hizari.spaceflightnews.ui.component.Greeting
import com.hizari.spaceflightnews.ui.theme.SpaceflightNewsTheme

/**
 * Spaceflight News - com.hizari.spaceflightnews.ui.screen
 *
 * Created by hudiohizari on 24/10/24.
 * https://github.com/hudiohizari
 *
 */

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    SpaceflightNewsTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier.fillMaxSize()
    ) {

        val (gMain) = createRefs()

        Greeting(
            modifier = Modifier.constrainAs(gMain) {
                top.linkTo(parent.top, 16.dp)
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
            },
            name = "User Name",
        )

    }
}