package com.example.and_practice.core.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<T, EVENT : UiEvent>(
    initialState: UiState<T>
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<UiState<T>> = _uiState.asStateFlow()

    private val _event = MutableSharedFlow<EVENT>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val event: SharedFlow<EVENT> = _event.asSharedFlow()

    protected fun updateState(reducer: (UiState<T>) -> UiState<T>) {
        _uiState.update(reducer)
    }

    // suspend 불필요 — tryEmit이 항상 성공함 (DROP_OLDEST 정책)
    protected fun sendEvent(event: EVENT) {
        _event.tryEmit(event)
    }
}
