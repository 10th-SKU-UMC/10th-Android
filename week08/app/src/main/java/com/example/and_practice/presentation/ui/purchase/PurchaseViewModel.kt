package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor() : BaseViewModel<PurchaseUiState, PurchaseEvent>(
    initialState = PurchaseUiState()
)
