package com.example.and_practice.presentation.ui.mypage

import com.example.and_practice.core.ui.UiEvent
import com.example.and_practice.data.remote.dto.FollowingPreviewDTO

data class MyPageData(
    val nickname: String,
    val profileImageUrl: String,
    val memberBenefitLabel: String,
    val followings: List<FollowingPreviewDTO>
)

sealed interface MyPageEvent : UiEvent {
    data object UpdateNicknameSuccess : MyPageEvent
    data class UpdateNicknameFailed(val message: String) : MyPageEvent
}
