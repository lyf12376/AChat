package com.example.roomtest.customizeComposable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.roomtest.R
import com.example.roomtest.viewModel.BottomBarViewModel

@Composable
fun TopBar(viewModel: BottomBarViewModel, modifier: Modifier)
{
    val selected by viewModel.selected
    val message by viewModel.message
    Box(modifier = modifier.fillMaxWidth()
        .background(Color("#F2F2F2".toColorInt()))
        .height(50.dp)
        .statusBarsPadding()
    ) {
        Text(
            text = topBarText(selected, message),
            modifier = Modifier.align(Alignment.Center),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                painterResource(id = R.drawable.search),
                contentDescription = "搜索",
                tint = Color.Unspecified // 设置tint为Color.Unspecified
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                painterResource(id = R.drawable.add),
                contentDescription = "加",
                tint = Color.Unspecified // 设置tint为Color.Unspecified
            )
        }
    }
}

fun topBarText(selected:Int, message:Int):String
{
    return if (message!=0)
        when (selected) {
            1 -> "A组($message)"
            2 -> "通讯录"
            else -> "发现"
        }
    else
        when (selected) {
            1 -> "微信"
            2 -> "通讯录"
            else -> "发现"
        }
}

//@Preview
//@Composable
//fun Preview()
//{
//    TopBar(viewModel = viewModel,Modifier)
//}