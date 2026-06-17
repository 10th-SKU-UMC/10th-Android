package com.example.week9.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.week9.model.sampleProducts

class ProductViewModel : ViewModel() {

    val wishlistedIds = mutableStateListOf<Int>().apply {
        addAll(sampleProducts.filter { it.isWishlisted }.map { it.id })
    }

    fun toggleWishlist(id: Int) {
        if (wishlistedIds.contains(id)) wishlistedIds.remove(id)
        else wishlistedIds.add(id)
    }
}
