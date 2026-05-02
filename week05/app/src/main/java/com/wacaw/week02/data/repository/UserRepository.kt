package com.wacaw.week02.data.repository

import com.wacaw.week02.data.remote.ApiClient
import com.wacaw.week02.data.remote.response.UserResponse
import retrofit2.Response

class UserRepository {
    suspend fun getUsers(): Response<UserResponse> {
        return ApiClient.userService.getUser()
    }
}