package com.example.and_practice.presentation.ui.cart

import com.example.and_practice.core.ui.UiEvent

data class CartUiState(
    val emptyMessage: String = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다.",
    val orderButtonText: String = "주문하기"
)

sealed interface CartEvent : UiEvent
