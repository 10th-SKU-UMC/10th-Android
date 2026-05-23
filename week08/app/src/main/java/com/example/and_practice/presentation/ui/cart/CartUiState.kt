package com.example.and_practice.presentation.ui.cart

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState

data class CartUiState(
    val emptyMessage: String = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다.",
    val orderButtonText: String = "주문하기"
) : UiState

sealed interface CartEvent : UiEvent
