package com.example.and_practice.presentation.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel<SplashUiState, SplashEvent>(
    initialState = UiState.Success(SplashUiState(shouldNavigateToHome = false))
) {
    init {
        login()
    }

    private fun login() {
        viewModelScope.launch {
            authRepository.login()
            // 성공·실패 모두 홈으로 이동 (week05 동일 동작)
            updateState { UiState.Success(SplashUiState(shouldNavigateToHome = true)) }
        }
    }
}
