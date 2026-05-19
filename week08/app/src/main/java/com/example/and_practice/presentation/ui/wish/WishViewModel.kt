package com.example.and_practice.presentation.ui.wish

import com.example.and_practice.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishViewModel @Inject constructor() : BaseViewModel<WishUiState, WishEvent>(
    initialState = WishUiState()
)
