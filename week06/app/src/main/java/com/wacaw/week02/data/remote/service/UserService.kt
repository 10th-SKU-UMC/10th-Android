package com.wacaw.week02.data.remote.service

import com.wacaw.week02.data.remote.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("api/users")
    suspend fun getUser(): Response<UserResponse>
}