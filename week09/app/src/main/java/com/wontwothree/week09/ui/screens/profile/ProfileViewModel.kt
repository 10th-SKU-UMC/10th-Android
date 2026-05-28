package com.wontwothree.week09.ui.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wontwothree.week09.data.remote.RetrofitClient
import com.wontwothree.week09.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel(){
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _following = MutableStateFlow<List<User>>(emptyList())
    val following: StateFlow<List<User>> = _following

    init {
        // 유저 가져오기
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getUser(id = 1)
                _user.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("ProfileViewModel", "유저 로드 실패: ${e.message}")
            }
        }

        // 팔로잉 목록 가져오기
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getUsers(page = 1)
                _following.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("ProfileViewModel", "팔로잉 로드 실패: ${e.message}")
            }
        }
    }
}