package com.example.roomtest.nav.chatPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.roomtest.R
import com.example.roomtest.viewModel.BottomBarViewModel

@Composable
fun chatPage(navController: NavController, senderName:String, peopleNum:Int)
{
    val messages = remember {
        mutableStateOf(0)
    }

    Box (Modifier.fillMaxSize()){
        chatTopBar(navController = navController, senderName = senderName, modifier = Modifier.align(Alignment.TopCenter))
    }
    LazyColumn(Modifier
        .padding(top = 45.dp, bottom = 80.dp)
    ) { // 添加上下边距
        items(messages.value) {

        }
    }
}

@Composable
fun chatTopBar(navController: NavController, senderName: String, modifier: Modifier)
{
    val viewModel = BottomBarViewModel()
    Box(modifier = modifier
        .fillMaxWidth()
        .background(Color("#F2F2F2".toColorInt()))
        .height(50.dp)
    ) {

        Row (modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(
                painterResource(id = R.drawable.back),
                contentDescription = "返回",
                modifier = Modifier.clickable {
                    navController.navigateUp()
                })
        }
        Text(
            text = senderName,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                painterResource(id = R.drawable.more),
                contentDescription = "更多",
                tint = Color.Unspecified // 设置tint为Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}


//@Preview
//@Composable
//fun chatPagePreview()
//{
//    chatPage(senderName = "lyf", peopleNum = 1)
//}