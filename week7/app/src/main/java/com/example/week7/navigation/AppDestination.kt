package com.example.week7.navigation

import androidx.annotation.DrawableRes
import com.example.week7.R
import kotlinx.serialization.Serializable

sealed interface AppDestination {
    @Serializable
    data object Home: AppDestination
    @Serializable
    data object Buy : AppDestination
    @Serializable
    data object Wishlist : AppDestination
    @Serializable
    data object Bag : AppDestination
    @Serializable
    data object Profile : AppDestination
}
enum class BottomTab(
    val label: String,
    @DrawableRes val iconRes: Int,
    val destination: AppDestination,
) {
    HOME("홈", R.drawable.home, AppDestination.Home),
    BUY("구매하기", R.drawable.buy, AppDestination.Buy),
    WISHLIST("위시리스트", R.drawable.wishlist, AppDestination.Wishlist),
    BAG("장바구니", R.drawable.bag, AppDestination.Bag),
    PROFILE("프로필", R.drawable.profile, AppDestination.Profile),
}

