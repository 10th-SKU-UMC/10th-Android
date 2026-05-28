package com.example.and_practice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.example.and_practice.presentation.ui.cart.CartRoute
import com.example.and_practice.presentation.ui.home.HomeRoute
import com.example.and_practice.presentation.ui.mypage.MyPageRoute
import com.example.and_practice.presentation.ui.purchase.FavoriteViewModel
import com.example.and_practice.presentation.ui.purchase.PurchaseDetailRoute
import com.example.and_practice.presentation.ui.purchase.PurchaseRoute
import com.example.and_practice.presentation.ui.splash.SplashRoute
import com.example.and_practice.presentation.ui.wish.WishRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Splash,
        modifier = modifier
    ) {
        composable<Splash> {
            SplashRoute(
                onNavigateToHome = {
                    navController.navigate(Home(title = "Discover")) {
                        popUpTo(Splash) { inclusive = true }
                    }
                }
            )
        }

        composable<Cart> {
            CartRoute(
                onNavigateToPurchase = {
                    navController.navigate(Purchase) {
                        popUpTo(Cart) { inclusive = true }
                    }
                }
            )
        }

        composable<MyPage> {
            MyPageRoute()
        }

        // Home, Purchase, Wish, PurchaseDetail을 하나의 그래프로 묶어 FavoriteViewModel 공유
        navigation<MainGraph>(startDestination = Home(title = "Discover")) {

            composable<Home> { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry<MainGraph>()
                }
                val favoriteViewModel: FavoriteViewModel = hiltViewModel(parentEntry)
                val home = backStackEntry.toRoute<Home>()
                HomeRoute(
                    title = home.title,
                    favoriteViewModel = favoriteViewModel,
                    onProductClick = { productId ->
                        navController.navigate(PurchaseDetail(productId = productId))
                    }
                )
            }

            composable<Purchase> { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry<MainGraph>()
                }
                val favoriteViewModel: FavoriteViewModel = hiltViewModel(parentEntry)
                PurchaseRoute(
                    favoriteViewModel = favoriteViewModel,
                    onProductClick = { productId ->
                        navController.navigate(PurchaseDetail(productId = productId))
                    }
                )
            }

            composable<Wish> { backStackEntry ->
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry<MainGraph>()
                }
                val favoriteViewModel: FavoriteViewModel = hiltViewModel(parentEntry)
                WishRoute(
                    favoriteViewModel = favoriteViewModel,
                    onProductClick = { productId ->
                        navController.navigate(PurchaseDetail(productId = productId))
                    }
                )
            }

            composable<PurchaseDetail> { backStackEntry ->
                val detail = backStackEntry.toRoute<PurchaseDetail>()
                PurchaseDetailRoute(
                    productId = detail.productId,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
