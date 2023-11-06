package com.example.roomtest.nav.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainPage(navController: NavController) {
    BottomNavigation {
        BottomNavigationItem(selected = false, onClick = { navController.navigate("") }, icon = {  })
    }
}