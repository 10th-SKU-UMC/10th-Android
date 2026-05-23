package kr.co.umc.nike.presentation.util

import androidx.compose.runtime.Composable

/**
 * UI의 다양한 상태(Idle, Loading, Success, Error)를 모델링하는 공통 Sealed Class입니다.
 * 주로 비동기 작업의 진행 상황에 따라 UI를 분기 처리할 때 사용됩니다.
 *
 * @param T 성공(Success) 상태일 때 보유할 데이터의 타입입니다.
 */
sealed class UiState<out T> {
    data object Idle : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

/**
 * 현재 [UiState]를 소비하여 각 상태(Idle, Loading, Success, Error)에 따른 UI를 처리합니다.
 * DSL 기반 방식을 사용하여 각 상태에 맞는 Composable 컴포넌트를 렌더링할 수 있습니다.
 *
 * @param T [UiState]에 포함된 데이터의 타입입니다.
 * @param block [UiStateHandler]을 통해 각 상태별 UI 로직을 정의하는 람다 블록입니다.
 */
@Suppress("ComposableNaming")
@Composable
inline fun <T> UiState<T>.consume(
    block: UiStateHandler<T>.() -> Unit
) {
    UiStateHandler<T>()
        .apply(block)
        .render(this)
}