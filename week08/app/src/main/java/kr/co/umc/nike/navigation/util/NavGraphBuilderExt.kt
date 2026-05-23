package kr.co.umc.nike.navigation.util

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kr.co.umc.nike.navigation.route.AppGraph
import kr.co.umc.nike.navigation.route.MainDestination
import kr.co.umc.nike.presentation.bag.screen.BagScreen
import kr.co.umc.nike.presentation.buy.screen.BuyScreen
import kr.co.umc.nike.presentation.home.screen.HomeScreen
import kr.co.umc.nike.presentation.profile.screen.ProfileScreen
import kr.co.umc.nike.presentation.wish.screen.WishScreen

/**
 * 앱의 주요 화면들을 구성하는 메인 네비게이션 그래프를 설정하는 NavGraphBuilder 확장함수.
 *
 * 그래프의 목적지(Destination)와
 * 각 목적지에 대응하는 화면(Composable) 간의 매핑을 정의합니다.
 */
fun NavGraphBuilder.mainGraph(
    navController: NavController,
    start: MainDestination = MainDestination.Home
) {

    navigation<AppGraph.MainGraph>(
        startDestination = start
    ) {

        composable<MainDestination.Home> {
            HomeScreen()
        }

        composable<MainDestination.Buy> {
            BuyScreen()
        }

        composable<MainDestination.WishList> {
            WishScreen()
        }

        composable<MainDestination.Bag> {
            BagScreen(
                onOrderClick = {
                    navController.navigateToBottomBarDestination(MainDestination.Buy)
                }
            )
        }

        composable<MainDestination.Profile> {
            ProfileScreen()
        }
    }
}