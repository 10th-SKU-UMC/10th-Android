package kr.co.umc.nike.navigation.util

import androidx.navigation.NavController
import kr.co.umc.nike.navigation.route.MainDestination

/**
 * 하단 네비게이션 바의 특정 최상위 목적지(Top-level destination)로 이동합니다.
 *
 * 이 함수는 하단 바 네비게이션의 표준 로직을 처리합니다:
 * - 목적지들이 쌓이는 것을 방지하기 위해 그래프의 시작 목적지까지 팝업(Pop up)합니다.
 * - 팝업된 목적지들의 상태를 저장합니다.
 * - 동일한 항목을 재선택할 때 중복 인스턴스가 생성되지 않도록 합니다 (launchSingleTop).
 * - 이전에 방문했던 목적지를 다시 선택할 때 저장된 상태를 복구합니다.
 *
 * @param destination 이동하려는 대상 [MainDestination].
 */
fun NavController.navigateToBottomBarDestination(
    destination: MainDestination
) {
    navigate(destination) {
        popUpTo<MainDestination.Home> {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}