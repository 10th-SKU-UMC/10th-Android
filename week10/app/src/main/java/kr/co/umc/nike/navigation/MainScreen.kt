package kr.co.umc.nike.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.co.umc.nike.R
import kr.co.umc.nike.navigation.model.BottomBarItem
import kr.co.umc.nike.navigation.route.AppGraph
import kr.co.umc.nike.navigation.route.MainDestination
import kr.co.umc.nike.navigation.util.NavTransaction.fadeInTransition
import kr.co.umc.nike.navigation.util.NavTransaction.fadeOutTransition
import kr.co.umc.nike.navigation.util.mainGraph
import kr.co.umc.nike.navigation.util.navigateToBottomBarDestination
import kr.co.umc.nike.navigation.util.toMainDestination
import kr.co.umc.nike.ui.theme.NikeTheme

/**
 * 나이키 애플리케이션의 최상위(루트) 컴포저블 함수입니다.
 *
 * 이 함수는 다음과 같은 앱의 주요 내비게이션 구조를 설정합니다:
 * - 전체적인 레이아웃을 관리하는 [Scaffold]를 구성합니다.
 * - 주요 내비게이션 목적지를 표시하는 하단 바([BottomBar])를 구현합니다.
 * - 홈, 구매, 위시리스트, 장바구니, 프로필 등 각 화면 간의 라우팅을 처리하는 [NavHost]를 관리합니다.
 */
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // 현재 네비게이션 상태를 관찰하는 state 변수
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // 현재 백스택 최상단의 Destination
    val currentDestination = navBackStackEntry?.destination.toMainDestination()

    Scaffold(
        bottomBar = {
            BottomBar(
                items = BottomBarItem.entries,
                currentDestination = currentDestination,
                onNavigate = { destination ->
                    navController.navigateToBottomBarDestination(destination)
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppGraph.MainGraph,
            modifier = Modifier.padding(innerPadding),

            // 전환 속도 설정
            enterTransition = fadeInTransition(),
            exitTransition = fadeOutTransition(),
            popEnterTransition = fadeInTransition(),
            popExitTransition = fadeOutTransition()

        ) {
            mainGraph(navController, MainDestination.Home)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NikeAppPreview() {
    NikeTheme {
        MainScreen()
    }
}
