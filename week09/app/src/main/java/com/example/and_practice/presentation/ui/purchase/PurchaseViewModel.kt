package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.mock.PurchaseMockData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor() : BaseViewModel<PurchaseData, PurchaseEvent>(
    initialState = UiState.Success(PurchaseData(products = PurchaseMockData.products))
)
