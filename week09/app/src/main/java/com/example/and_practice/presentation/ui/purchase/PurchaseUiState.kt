package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.data.mock.MockProductData

data class PurchaseData(
    val products: List<MockProductData>
)

sealed interface PurchaseEvent : UiEvent
