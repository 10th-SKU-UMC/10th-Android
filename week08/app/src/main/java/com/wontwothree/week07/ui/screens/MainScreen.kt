package com.wontwothree.week07.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wontwothree.week07.navigation.AppDestination
import com.wontwothree.week07.navigation.NavGraph
import com.wontwothree.week07.ui.components.BottomNavBar

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavBar(
                isTabSelected = { destination ->
                    currentDestination?.hasRoute(destination::class) == true // 선택 여부 넣어줌
                },
                onTabSelected = { destination ->
                    navController.navigate(destination) {
                        popUpTo(AppDestination.Home) { saveState = true }
                        launchSingleTop = true // 중복 생성 방지
                        restoreState = true // 화면 상태 유지
                    }
                }
            )
        }
    ) { innerPadding ->
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavGraph(navController = navController)
        }
    }
}