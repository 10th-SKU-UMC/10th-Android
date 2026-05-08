package com.example.week5.ui.buy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5.data.local.ProductEntity
import com.example.week5.domain.repository.LocalProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
@HiltViewModel
class BuyItemViewModel @Inject constructor(
    private val repository: LocalProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(BuyItemUiState())
    val uiState: StateFlow<BuyItemUiState> = _uiState.asStateFlow()

    private val categoryFlow = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            categoryFlow
                .flatMapLatest { category ->
                    if (category.isNullOrEmpty()) {
                        repository.getAllProductsStream()
                    } else {
                        repository.getProductsByCategoryStream(category)
                    }
                }
                .collect { products ->
                    _uiState.update { it.copy(products = products) }
                }
        }
    }

    fun setCategory(category: String?) {
        categoryFlow.value = category
    }

    fun toggleWishlist(item: ProductEntity) {
        viewModelScope.launch {
            repository.toggleWishlist(item.id, !item.isWishlisted)
        }
    }
}

data class BuyItemUiState(
    val products: List<ProductEntity> = emptyList()
)
