package com.wontwothree.week07.ui.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.wontwothree.week07.navigation.AppDestination
import com.wontwothree.week07.ui.theme.Week07Theme

data class BottomNavItem(
    val destination: AppDestination,
    val icon: ImageVector,
    val label: String
)

val bottomNavItems = listOf(
    BottomNavItem(AppDestination.Home, Icons.Outlined.Home, "홈"),
    BottomNavItem(AppDestination.Shop, Icons.Outlined.Search, "구매하기"),
    BottomNavItem(AppDestination.Wishlist, Icons.Outlined.FavoriteBorder, "위시리스트"),
    BottomNavItem(AppDestination.Cart, Icons.Outlined.ShoppingCart, "장바구니"),
    BottomNavItem(AppDestination.Profile, Icons.Outlined.Person, "프로필"),
)

@Composable
fun BottomNavBar(
    currentDestination: NavDestination?,
    onTabSelected: (AppDestination) -> Unit) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {
        bottomNavItems.forEach { item ->
            val selected = currentDestination?.hasRoute(item.destination::class) == true

            NavigationBarItem(
                selected = selected,
                onClick = { onTabSelected(item.destination) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(
                        text = item.label
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedIconColor = Color(0xFFBDBDBD),
                    unselectedTextColor = Color(0xFFBDBDBD),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        BottomNavBar(currentDestination = null,
            onTabSelected = { })
    }
}
