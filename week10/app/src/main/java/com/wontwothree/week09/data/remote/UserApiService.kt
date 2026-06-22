package com.wontwothree.week09.data.remote

import com.wontwothree.week09.domain.model.UserResponse
import com.wontwothree.week09.domain.model.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiService {

    @GET("api/users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponse

    @GET("api/users/")
    suspend fun getUsers(@Query("page") page:Int=1): UsersResponse
}