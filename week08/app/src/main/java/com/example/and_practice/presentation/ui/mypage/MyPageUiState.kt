package com.example.and_practice.presentation.ui.mypage

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.core.ui.UiState

data class MyPageUiState(
    val title: String = "프로필"
) : UiState

sealed interface MyPageEvent : UiEvent
