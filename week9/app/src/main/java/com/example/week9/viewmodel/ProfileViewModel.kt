package com.example.week9.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week9.model.ReqresUser
import com.example.week9.network.ApiClient
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    var currentUser by mutableStateOf<ReqresUser?>(null)
        private set

    var followingList by mutableStateOf<List<ReqresUser>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = ApiClient.productService.getUsers()
                val users = response.data
                if (users.isNotEmpty()) {
                    currentUser = users.find { it.id == 1 }
                    followingList = users.filter { it.id != 1 }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }
}
