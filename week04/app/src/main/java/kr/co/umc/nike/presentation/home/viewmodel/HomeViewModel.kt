package kr.co.umc.nike.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kr.co.umc.nike.domain.usecase.GetNewProductsUseCase
import kr.co.umc.nike.presentation.home.mapper.NewGoodMapper.toPresentation
import kr.co.umc.nike.presentation.home.model.NewGood
import kr.co.umc.nike.presentation.util.UiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNewProductsUseCase: GetNewProductsUseCase
): ViewModel()  {

    private val _newGoodsState = MutableStateFlow<UiState<List<NewGood>>>(UiState.Idle)
    val newGoodsState: Flow<UiState<List<NewGood>>> = _newGoodsState.asStateFlow()


    init {
        loadNewProducts()
    }

    private fun loadNewProducts() {
        viewModelScope.launch {
            _newGoodsState.value = UiState.Loading

            getNewProductsUseCase()
                .map { products ->
                    products.map { it.toPresentation() }  // ui 모델로 변환
                }
                .catch { e ->
                    _newGoodsState.value = UiState.Error(e.message ?: "Unknown Error")
                }
                .collect { goods ->
                    _newGoodsState.value = UiState.Success(goods)
                }
        }
    }
}