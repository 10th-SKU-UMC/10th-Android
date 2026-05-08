package com.wacaw.week02.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wacaw.week02.data.entity.ProductEntity
import com.wacaw.week02.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PurchaseViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel(){
    private val _products = MutableLiveData<List<ProductEntity>>()
    val products: LiveData<List<ProductEntity>> = _products

    init {
        viewModelScope.launch (Dispatchers.IO) {
            repository.insertData()
            val products = repository.getAllProducts()
            _products.postValue(products)
        }
    }
    fun toggleLike(id: Int, isLiked: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateLikeStatus(id, isLiked)
            val updated = repository.getAllProducts()
            _products.postValue(updated)
        }
    }
}