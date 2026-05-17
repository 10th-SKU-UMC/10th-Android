package kr.co.umc.nike.navigation.util

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry

/**
 * Jetpack Compose Navigation 사용 시 화면 전환 애니메이션(Transition)을 정의하는 유틸리티 객체입니다.
 *
 * 이 객체는 [AnimatedContentTransitionScope] 내에서 사용할 수 있는 진입(Enter) 및 진출(Exit) 애니메이션을
 * 람다 형태로 제공하며, 기본적으로 [tween] 애니메이션 스펙을 사용합니다.
 *
 * 주요 기능:
 * - [fadeInTransition]: 화면이 나타날 때 점진적으로 투명도가 변하는 효과를 생성합니다.
 * - [fadeOutTransition]: 화면이 사라질 때 점진적으로 투명도가 변하는 효과를 생성합니다.
 *
 */
object NavTransaction {
    fun fadeInTransition(duration: Int = 200)
    : AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        fadeIn(animationSpec = tween(duration))
    }

    fun fadeOutTransition(duration: Int = 200)
            : AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
        fadeOut(animationSpec = tween(duration))
    }
}