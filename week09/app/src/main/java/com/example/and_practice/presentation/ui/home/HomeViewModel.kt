package com.example.and_practice.presentation.ui.home

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.presentation.ui.home.mapper.HomeUiStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUiStateMapper: HomeUiStateMapper
) : BaseViewModel<HomeUiState, HomeEvent>(
    initialState = UiState.Success(HomeUiState())
) {

    fun updateHome(title: String) {
        updateState { UiState.Success(homeUiStateMapper(title)) }
    }
}
