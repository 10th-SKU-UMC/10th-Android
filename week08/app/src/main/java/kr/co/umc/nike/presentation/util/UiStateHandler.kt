package kr.co.umc.nike.presentation.util

import androidx.compose.runtime.Composable

/**
 * UI 레이어에서 [UiState]의 상태 변화를 처리하기 위한 DSL(Domain-Specific Language) 빌더 클래스입니다.
 *
 * 이 클래스는 데이터 기반 작업의 각 상태(Idle, Loading, Success, Error)에 따라
 * UI가 어떻게 렌더링되어야 하는지를 선언적인 방식으로 정의할 수 있는 API을 제공합니다.
 *
 * @param T [UiState.Success] 상태일 때 전달받는 데이터의 타입입니다.
 */
class UiStateHandler<T> {

    private var idleBlock: (@Composable () -> Unit)? = null
    private var loadingBlock: (@Composable () -> Unit)? = null
    private var successBlock: (@Composable (T) -> Unit)? = null
    private var errorBlock: (@Composable (String) -> Unit)? = null

    fun idle(block: @Composable () -> Unit) {
        idleBlock = block
    }

    fun loading(block: @Composable () -> Unit) {
        loadingBlock = block
    }

    fun success(block: @Composable (T) -> Unit) {
        successBlock = block
    }

    fun error(block: @Composable (String) -> Unit) {
        errorBlock = block
    }

    /**
     * 현재 [UiState]의 상태에 따라 미리 정의된 UI 블록을 실행하여 화면을 렌더링합니다.
     *
     * @param state 처리할 현재 UI 상태입니다.
     */
    @Suppress("ComposableNaming")
    @Composable
    fun render(state: UiState<T>) {
        when (state) {

            UiState.Idle -> {
                idleBlock?.invoke()
            }

            UiState.Loading -> {
                loadingBlock?.invoke()
            }

            is UiState.Success -> {
                successBlock?.invoke(state.data)
            }

            is UiState.Error -> {
                errorBlock?.invoke(state.message)
            }
        }
    }
}