package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState

data class PurchaseUiState(
    val title: String = "구매하기"
) : UiState

sealed interface PurchaseEvent : UiEvent
