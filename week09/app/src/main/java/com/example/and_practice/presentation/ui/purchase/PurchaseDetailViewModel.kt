package com.example.and_practice.presentation.ui.purchase

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.mock.PurchaseDetailMockData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PurchaseDetailViewModel @Inject constructor() :
    BaseViewModel<PurchaseDetailUiState, PurchaseDetailEvent>(
        initialState = UiState.Success(PurchaseDetailUiState())
    ) {

    fun loadProduct(productId: Int) {
        val product = PurchaseDetailMockData.products.find { it.id == productId }
        updateState { current ->
            if (current is UiState.Success)
                UiState.Success(current.data.copy(product = product))
            else
                UiState.Success(PurchaseDetailUiState(product = product))
        }
    }
}
