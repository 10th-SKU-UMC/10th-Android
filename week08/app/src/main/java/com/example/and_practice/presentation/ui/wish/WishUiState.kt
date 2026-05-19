package com.example.and_practice.presentation.ui.wish

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState

data class WishUiState(
    val title: String = "위시리스트"
) : UiState

sealed interface WishEvent : UiEvent
