package com.example.week9.network

import com.example.week9.model.ReqresUserResponse
import retrofit2.http.GET

interface ProductService {
    @GET("api/users")
    suspend fun getUsers(): ReqresUserResponse
}