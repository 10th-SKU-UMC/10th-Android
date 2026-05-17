package com.example.week7.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.week7.navigation.AppDestination
import com.example.week7.navigation.BottomTab
import com.example.week7.ui.component.AppBottomBar
import com.example.week7.ui.screen.BagScreen
import com.example.week7.ui.screen.BuyScreen
import com.example.week7.ui.screen.HomeScreen
import com.example.week7.ui.screen.ProfileScreen
import com.example.week7.ui.screen.WishlistScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val current = backStackEntry?.destination
    val selected = when {
        current?.hasRoute<AppDestination.Home>() == true -> BottomTab.HOME
        current?.hasRoute<AppDestination.Buy>() == true -> BottomTab.BUY
        current?.hasRoute<AppDestination.Wishlist>() == true -> BottomTab.WISHLIST
        current?.hasRoute<AppDestination.Bag>() == true -> BottomTab.BAG
        current?.hasRoute<AppDestination.Profile>() == true -> BottomTab.PROFILE
        else -> BottomTab.HOME
    }

    Scaffold(
        bottomBar = {
            AppBottomBar(
                selected = selected,
                onTabSelected = { tab -> navController.navigateTab(tab.destination) },
            )
        },
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Home,
            modifier = Modifier.fillMaxSize().padding(padding),
        ) {
            composable<AppDestination.Home> { HomeScreen() }
            composable<AppDestination.Buy> { BuyScreen() }
            composable<AppDestination.Wishlist> { WishlistScreen() }
            composable<AppDestination.Bag> {
                BagScreen(
                    onBuyClick = {
                        navController.navigate(AppDestination.Buy) }
                )
            }
            composable<AppDestination.Profile> { ProfileScreen() }
        }
    }
}

private fun NavHostController.navigateTab(dest: AppDestination) {
    navigate(dest) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}