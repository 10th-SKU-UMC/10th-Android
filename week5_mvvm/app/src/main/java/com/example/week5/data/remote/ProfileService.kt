package com.example.week5.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileService {
    // 유저 1명 가져오기
    @GET("api/users/{id}")
    suspend fun getUser(
        @Path("id") id: Int
    ): Response<UserSingleResponse>

    // 유저 리스트 가져오기
    @GET("api/users")
    suspend fun getUsers(
        @Query("page") page: Int
    ): Response<UserResponse>
}
