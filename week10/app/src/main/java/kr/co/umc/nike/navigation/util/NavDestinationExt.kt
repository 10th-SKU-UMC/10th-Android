package kr.co.umc.nike.navigation.util

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import kr.co.umc.nike.navigation.route.MainDestination

/**
 * [NavDestination]을 해당하는 [MainDestination]으로 변환합니다.
 *
 * 현재 목적지의 경로(Route)를 확인하여 홈, 쇼핑, 위시리스트, 장바구니, 프로필 중 일치하는
 * [MainDestination] 타입을 반환합니다.
 *
 * @return 일치하는 [MainDestination], 일치하는 목적지가 없거나 [NavDestination]이 null인 경우 null을 반환합니다.
 */
fun NavDestination?.toMainDestination(): MainDestination? {
    return when {
        this?.hasRoute(MainDestination.Home::class) == true ->
            MainDestination.Home

        this?.hasRoute(MainDestination.Buy::class) == true ->
            MainDestination.Buy

        this?.hasRoute(MainDestination.WishList::class) == true ->
            MainDestination.WishList

        this?.hasRoute(MainDestination.Bag::class) == true ->
            MainDestination.Bag

        this?.hasRoute(MainDestination.Profile::class) == true ->
            MainDestination.Profile

        else -> null
    }
}