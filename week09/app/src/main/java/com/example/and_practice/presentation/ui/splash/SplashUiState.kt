package com.example.and_practice.presentation.ui.splash

import com.example.and_practice.core.ui.UiEvent

data class SplashUiState(
    val shouldNavigateToHome: Boolean = true
)

sealed interface SplashEvent : UiEvent
