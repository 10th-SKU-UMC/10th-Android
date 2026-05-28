package com.wacaw.week09.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wacaw.week09.ui.screens.cart.CartScreen
import com.wacaw.week09.ui.screens.home.HomeScreen
import com.wacaw.week09.ui.screens.profile.ProfileScreen
import com.wacaw.week09.ui.screens.shop.ShopScreen
import com.wacaw.week09.ui.screens.whishlist.WhishlistScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Home // 첫 실행 화면
    ) {
        composable<AppDestination.Home> { HomeScreen() }
        composable<AppDestination.Shop> { ShopScreen() }
        composable<AppDestination.Wishlist> { WhishlistScreen() }
        composable<AppDestination.Cart> {
            CartScreen(
                onOrderBtnClick = {
                    navController.navigate(AppDestination.Shop) {
                        popUpTo(AppDestination.Home) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable<AppDestination.Profile> { ProfileScreen() }
    }
}