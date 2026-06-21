package com.example.week10.network

import com.example.week10.model.ReqresUserResponse
import retrofit2.http.GET

interface ProductService {
    @GET("api/users")
    suspend fun getUsers(): ReqresUserResponse
}