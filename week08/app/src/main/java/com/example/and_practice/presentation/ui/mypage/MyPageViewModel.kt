package com.example.and_practice.presentation.ui.mypage

import com.example.and_practice.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor() : BaseViewModel<MyPageUiState, MyPageEvent>(
    initialState = MyPageUiState()
)
