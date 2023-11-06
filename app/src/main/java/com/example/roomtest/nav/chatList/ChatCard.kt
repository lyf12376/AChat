package com.example.roomtest.nav.chatList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun chatCard(navController: NavController, name:String, message:String="", viewModel: BottomBarViewModel, isEnd: Boolean)
{
    val sender = "lyf"

    Card (Modifier.fillMaxWidth()
        .clickable { navController.navigate("chat/$sender/1") }
        .height(100.dp),
    ){
        Box(
            Modifier
                .fillMaxSize()
                .background(Color("#FFFFFF".toColorInt())),
            contentAlignment = Alignment.CenterStart
        )
        {
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    painterResource(id = R.drawable.bear),
                    contentDescription = name,
                    Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .align(Alignment.CenterVertically),
                    tint = Color.Unspecified // 设置tint为Color.Unspecified
                )
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = name,fontSize = 20.sp)
                    Text(text = "hello lyf,你好，刘一凡", color = Color("#B3B3B3".toColorInt()), fontSize = 15.sp, fontWeight = FontWeight.Light)
                }
            }
            if (!isEnd)
                Divider(color = Color("#bcbcbc".toColorInt()), thickness = 0.5.dp, modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 100.dp))
        }
    }

}


//@Preview
//@Composable
//fun p()
//{
//    chatCard(name = "lyf", viewModel = WeViewModel())
//}