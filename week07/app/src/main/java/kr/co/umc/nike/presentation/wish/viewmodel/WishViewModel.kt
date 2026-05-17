package kr.co.umc.nike.presentation.wish.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.umc.nike.domain.usecase.GetWishProductsUseCase
import kr.co.umc.nike.presentation.mapper.PresentationMapper.toWishGood
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.presentation.wish.model.WishGood
import javax.inject.Inject

@HiltViewModel
class WishViewModel @Inject constructor(
    private val getWishProductsUseCase: GetWishProductsUseCase
): ViewModel() {

    private val _wishGoodsState = MutableStateFlow<UiState<List<WishGood>>>(UiState.Idle)
    val wishGoodsState: Flow<UiState<List<WishGood>>> = _wishGoodsState.asStateFlow()

    init {
        loadWishProducts()
    }

    private fun loadWishProducts() {
        viewModelScope.launch {
            _wishGoodsState.value = UiState.Loading

            getWishProductsUseCase()
                .map { products ->
                    products.map { it.toWishGood() }  // ui 모델로 변환
                }
                .catch { e ->
                    _wishGoodsState.value = UiState.Error(e.message ?: "Unknown Error")
                }
                .collect { goods ->
                    _wishGoodsState.value = UiState.Success(goods)
                }
        }
    }
}