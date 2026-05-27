package com.example.and_practice.presentation.ui.home.mapper

import com.example.and_practice.data.mock.HomeMockData
import com.example.and_practice.presentation.ui.home.HomeUiState
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import javax.inject.Inject

class HomeUiStateMapper @Inject constructor() {

    operator fun invoke(title: String): HomeUiState {
        val now = LocalDateTime.now()
        val dayOfWeek = now.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.KOREAN)
        val dateText = "${now.format(HOME_DATE_FORMATTER)} $dayOfWeek"

        return HomeUiState(
            title = title,
            dateText = dateText,
            recentItems = HomeMockData.recentItems
        )
    }

    private companion object {
        private val HOME_DATE_FORMATTER: DateTimeFormatter =
            DateTimeFormatter.ofPattern("MM월 dd일")
    }
}
