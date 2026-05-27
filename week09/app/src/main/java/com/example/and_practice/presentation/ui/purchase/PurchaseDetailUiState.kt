package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.data.mock.MockProductDetailData

data class PurchaseDetailUiState(
    val product: MockProductDetailData? = null
)

sealed interface PurchaseDetailEvent : UiEvent
