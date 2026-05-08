package com.wacaw.week02.data.repository

import com.wacaw.week02.data.remote.ApiClient
import com.wacaw.week02.data.remote.response.UserData
import com.wacaw.week02.data.remote.response.UserResponse
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor() {

    suspend fun getUsers(): Result<List<UserData>> {
        // runCatching -> try/catch를 Result로 자동 변환
        return runCatching {
            val response = ApiClient.userService.getUser()

            if (response.isSuccessful) {
                response.body()?.data ?: emptyList()
            } else {
                throw Exception("서버 오류: ${response.code()}")
            }
        }
    }
}