package com.example.and_practice.presentation.ui.wish

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.data.mock.MockProductData

data class WishData(
    val products: List<MockProductData> = emptyList()
)

sealed interface WishEvent : UiEvent
