package kr.co.umc.nike.navigation.route

import kotlinx.serialization.Serializable

/**
 * 애플리케이션 내의 최상위 탐색 대상(Navigation Destination)을 정의하는 인터페이스입니다.
 *
 * 홈, 구매, 위시리스트, 장바구니, 프로필 등 앱의 주요 화면 이동을 위한
 * 타입 안정성(Type-safety) 있는 경로 정의를 위해 사용됩니다.
 */
sealed interface MainDestination {

    @Serializable
    data object Home : MainDestination

    @Serializable
    data object Buy : MainDestination

    @Serializable
    data object WishList : MainDestination

    @Serializable
    data object Bag : MainDestination

    @Serializable
    data object Profile : MainDestination

}