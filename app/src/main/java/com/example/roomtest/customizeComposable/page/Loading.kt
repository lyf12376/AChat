package com.example.roomtest.customizeComposable.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.roomtest.R

@Composable
fun Loading() {
    Box(modifier = Modifier
        .fillMaxSize()
        ) {
        Image(
            painterResource(id = R.drawable.wait),
            contentDescription = "wait",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }
}
@Preview
@Composable
fun pre()
{
    Loading()
}


