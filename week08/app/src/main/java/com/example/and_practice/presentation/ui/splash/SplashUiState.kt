package com.example.and_practice.presentation.ui.splash

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState

data class SplashUiState(
    val shouldNavigateToHome: Boolean = true
) : UiState

sealed interface SplashEvent : UiEvent
