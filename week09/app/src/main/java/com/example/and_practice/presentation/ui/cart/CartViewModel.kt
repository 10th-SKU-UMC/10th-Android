package com.example.and_practice.presentation.ui.cart

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : BaseViewModel<CartUiState, CartEvent>(
    initialState = UiState.Success(CartUiState())
)
