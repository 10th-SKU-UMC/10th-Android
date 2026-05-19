package com.example.and_practice.presentation.ui.purchase

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * 좋아요 뷰모델
 */
@HiltViewModel
class FavoriteViewModel @Inject constructor() : ViewModel() {
    private val _likedProductIds = MutableStateFlow<Set<Int>>(emptySet())
    val likedProductIds: StateFlow<Set<Int>> = _likedProductIds

    fun toggleLike(productId: Int) {
        _likedProductIds.update { ids ->
            if (productId in ids) ids - productId else ids + productId
        }
    }
}