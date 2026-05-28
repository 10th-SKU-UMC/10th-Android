package com.example.and_practice.presentation

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class MainActivityUiState(
    val isReady: Boolean = true
)

sealed interface MainActivityEvent : UiEvent

@HiltViewModel
class MainActivityViewModel @Inject constructor() : BaseViewModel<MainActivityUiState, MainActivityEvent>(
    initialState = UiState.Success(MainActivityUiState())
)
