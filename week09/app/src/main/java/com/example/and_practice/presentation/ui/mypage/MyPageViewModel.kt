package com.example.and_practice.presentation.ui.mypage

import androidx.lifecycle.viewModelScope
import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.remote.api.toApiError
import com.example.and_practice.data.remote.dto.UpdateMyProfileRequestDTO
import com.example.and_practice.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : BaseViewModel<MyPageData, MyPageEvent>(
    initialState = UiState.Loading
) {

    init {
        fetchProfile()
    }

    fun retry() = fetchProfile()

    private fun fetchProfile() {
        viewModelScope.launch {
            updateState { UiState.Loading }
            profileRepository.getMyProfile()
                .onSuccess { data ->
                    updateState {
                        UiState.Success(
                            MyPageData(
                                nickname = data.nickname,
                                profileImageUrl = data.profileImageUrl,
                                memberBenefitLabel = data.memberBenefitLabel,
                                followings = data.followings
                            )
                        )
                    }
                }
                .onFailure { throwable ->
                    updateState { UiState.Error(throwable.toApiError()) }
                }
        }
    }

    fun updateNickname(nickname: String) {
        viewModelScope.launch {
            profileRepository.updateProfile(UpdateMyProfileRequestDTO(nickname = nickname))
                .onSuccess {
                    // 화면 전체 교체 없이 닉네임만 갱신
                    updateState { current ->
                        if (current is UiState.Success)
                            UiState.Success(current.data.copy(nickname = nickname))
                        else current
                    }
                    sendEvent(MyPageEvent.UpdateNicknameSuccess)
                }
                .onFailure { throwable ->
                    // 에러 시 이벤트로만 알림, 화면 상태 유지
                    sendEvent(MyPageEvent.UpdateNicknameFailed(throwable.toApiError().defaultMessage))
                }
        }
    }
}
