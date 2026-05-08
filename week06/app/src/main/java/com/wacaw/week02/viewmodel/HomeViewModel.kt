package com.wacaw.week02.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wacaw.week02.data.entity.ProductEntity
import com.wacaw.week02.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel(){
    private val _newProducts = MutableStateFlow<List<ProductEntity>>(emptyList())
    val newProducts: StateFlow<List<ProductEntity>> = _newProducts.asStateFlow()

    init {
        // 앱 시작 시 DB 변화를 구독
        viewModelScope.launch {
            viewModelScope.launch(Dispatchers.IO) {
                repository.insertData()
                val products = repository.getProductsByCategoryName("NewArrival")
                _newProducts.value = products
            }
        }
    }



}