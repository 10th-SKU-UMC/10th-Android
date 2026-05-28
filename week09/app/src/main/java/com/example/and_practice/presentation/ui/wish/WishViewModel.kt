package com.example.and_practice.presentation.ui.wish

import com.example.and_practice.core.ui.BaseViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.mock.MockProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishViewModel @Inject constructor() : BaseViewModel<WishData, WishEvent>(
    initialState = UiState.Success(WishData())
) {
    fun updateWishProducts(allProducts: List<MockProductData>, likedIds: Set<Int>) {
        val filtered = allProducts.filter { it.id in likedIds }
        updateState { UiState.Success(WishData(products = filtered)) }
    }
}
