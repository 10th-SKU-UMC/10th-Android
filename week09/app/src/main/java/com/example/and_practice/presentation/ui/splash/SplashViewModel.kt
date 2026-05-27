package com.example.and_practice.presentation.ui.splash

import com.example.and_practice.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel<SplashUiState, SplashEvent>(
    initialState = SplashUiState()
)
