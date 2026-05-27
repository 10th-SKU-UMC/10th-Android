package com.example.and_practice.presentation.ui.home

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.data.mock.MockRecentItemData

data class HomeUiState(
    val title: String = "Discover",
    val dateText: String = "",
    val recentItems: List<MockRecentItemData> = emptyList()
)

sealed interface HomeEvent : UiEvent
