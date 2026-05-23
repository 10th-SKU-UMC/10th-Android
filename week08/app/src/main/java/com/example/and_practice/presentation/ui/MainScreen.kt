package com.example.and_practice.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.and_practice.R
import com.example.and_practice.presentation.component.AppBottomNavigationBar
import com.example.and_practice.presentation.navigation.AppNavHost
import com.example.and_practice.presentation.navigation.BottomNavItem
import com.example.and_practice.presentation.navigation.Cart
import com.example.and_practice.presentation.navigation.Home
import com.example.and_practice.presentation.navigation.MainGraph
import com.example.and_practice.presentation.navigation.MyPage
import com.example.and_practice.presentation.navigation.Purchase
import com.example.and_practice.presentation.navigation.PurchaseDetail
import com.example.and_practice.presentation.navigation.Wish

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination

    MainScreenScaffold(
        navController = navController,
        currentRoute = currentRoute
    )
}

@Composable
private fun MainScreenScaffold(
    navController: NavHostController,
    currentRoute: NavDestination?
) {
    Scaffold(
        bottomBar = {
            AppBottomNavigationBar(
                items = BottomNavItem.entries.toList(),
                selectedItem = currentRoute.toBottomNavItem(),
                iconResFor = ::iconResForBottomNavItem,
                onItemClick = { item ->
                    navController.navigateToBottomTab(item)
                }
            )
        }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

// 선택된 destination으로 이동
private fun NavHostController.navigateToBottomTab(item: BottomNavItem) {
    val destination = when (item) {
        BottomNavItem.HOME -> Home(title = "Discover")
        BottomNavItem.WISH -> Wish
        BottomNavItem.CART -> Cart
        BottomNavItem.PURCHASE -> Purchase
        BottomNavItem.MY_PAGE -> MyPage
    }

    navigate(destination) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

private fun NavDestination?.toBottomNavItem(): BottomNavItem? = when {
    this?.hasRoute<Home>() == true -> BottomNavItem.HOME
    this?.hasRoute<Wish>() == true -> BottomNavItem.WISH
    this?.hasRoute<Cart>() == true -> BottomNavItem.CART
    this?.hasRoute<Purchase>() == true -> BottomNavItem.PURCHASE
    this?.hasRoute<PurchaseDetail>() == true -> BottomNavItem.PURCHASE  // 상세도 구매하기 탭 선택
    this?.hasRoute<MyPage>() == true -> BottomNavItem.MY_PAGE
    else -> null
}

private fun iconResForBottomNavItem(item: BottomNavItem): Int = when (item) {
    BottomNavItem.HOME -> R.drawable.ic_housesimple
    BottomNavItem.WISH -> R.drawable.ic_heartstraight
    BottomNavItem.CART -> R.drawable.ic_bagsimple
    BottomNavItem.PURCHASE -> R.drawable.ic_listmagnifyingglass
    BottomNavItem.MY_PAGE -> R.drawable.ic_user
}
