package com.example.roomtest.nav.chatList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.roomtest.customizeComposable.component.TabBar
import com.example.roomtest.customizeComposable.component.TopBar
import com.example.roomtest.viewModel.BottomBarViewModel


@Composable
fun HomePage(navController: NavController, chatList: List<String>) {
    val viewModel = BottomBarViewModel()
    val message by viewModel.message

    Box(
        Modifier
            .fillMaxSize()
            .background(Color("#F2F2F2".toColorInt()))
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        TopBar(viewModel = viewModel, Modifier.align(Alignment.TopCenter))
        LazyColumn(
            Modifier
                .padding(top = 50.dp, bottom = 80.dp)
        ) { // 添加上下边距
            for ((i, name) in chatList.withIndex()) {
                if (i == chatList.lastIndex)
                    item {
                        chatCard(
                            name = name,
                            navController = navController,
                            viewModel = viewModel,
                            isEnd = true
                        )
                    }
                else
                    item {
                        chatCard(
                            name = name,
                            navController = navController,
                            viewModel = viewModel,
                            isEnd = false
                        )
                    }
            }
        }
        TabBar(viewModel, Modifier.align(Alignment.BottomCenter))
    }
}
