package kr.co.umc.nike.presentation.buy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.umc.nike.domain.usecase.GetAllProductsUseCase
import kr.co.umc.nike.domain.usecase.UpdateWishStatusUseCase
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.presentation.mapper.PresentationMapper.toGood
import kr.co.umc.nike.presentation.util.UiState
import javax.inject.Inject

@HiltViewModel
class GoodsViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val updateWishStateUseCase: UpdateWishStatusUseCase
): ViewModel() {

    private val _goodsState = MutableStateFlow<UiState<List<Good>>>(UiState.Idle)
    val goodsState: Flow<UiState<List<Good>>> = _goodsState.asStateFlow()

    init {
        loadGoods()
    }
    private fun loadGoods() {
        viewModelScope.launch {
            _goodsState.value = UiState.Loading

            getAllProductsUseCase()
                .map { products ->
                    products.map { it.toGood() }  // ui 모델로 변환
                }
                .catch { e ->
                    _goodsState.value = UiState.Error(e.message ?: "Unknown Error")
                }
                .collect { goods ->
                    _goodsState.value = UiState.Success(goods)
                }
            }
        }

    fun toggleWish(id: Int) {
        viewModelScope.launch {
            updateWishStateUseCase(id)
        }
    }

}