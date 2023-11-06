package com.example.roomtest.customizeComposable.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.roomtest.R
import com.example.roomtest.ui.theme.isSelected
import com.example.roomtest.ui.theme.unSelected
import com.example.roomtest.viewModel.BottomBarViewModel


@Composable
fun TabBar(viewModel: BottomBarViewModel, modifier: Modifier)
{
    val selected by viewModel.selected
    Row (modifier.background(Color("#F2F2F2".toColorInt())).navigationBarsPadding()){
        TabBarItem(if (selected == 1) R.drawable.wechat_filled else R.drawable.wechat_outline,
            "微信",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.selected.value = 1
                },
            if (selected == 1) isSelected else unSelected
        )

        TabBarItem(
            if (selected == 2) R.drawable.address_filled else R.drawable.address_outline,
            "通讯录",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.selected.value = 2
                },
            if (selected == 2) isSelected else unSelected
        )


        TabBarItem(
            if (selected == 3) R.drawable.discovery_filed else R.drawable.discover_outline,
            "发现",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.selected.value = 3
                },
            if (selected== 3) isSelected else unSelected
        )

        TabBarItem(if (selected == 4) R.drawable.mine_filled else R.drawable.mine_outline,
            "我",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    viewModel.selected.value = 4
                },
            if (selected == 4) isSelected else unSelected
        )
    }
}



@Composable
fun TabBarItem(iconId:Int, title: String, modifier: Modifier = Modifier, color: Color)
{
    Column (modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Icon(
            painterResource(id = iconId),
            contentDescription = title,
            tint = Color.Unspecified // 设置tint为Color.Unspecified
        )
        Text(text = title, color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun myPreview()
{
    val viewModel = BottomBarViewModel()
    TabBar(viewModel,Modifier)
}