package com.example.roomtest.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel



class BottomBarViewModel : ViewModel() {
        var selected = mutableStateOf(1)
        var message = mutableStateOf(1)
        var isChatting = mutableStateOf(false)
        var userName by mutableStateOf("")

}