package com.example.week9.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL="https://reqres.in/"
    private const val API_KEY="reqres_228f9fec273d4ecd8b0495f0ca4e5a1b"
    private val client=OkHttpClient.Builder()
        .addInterceptor{ chain ->
            val newRequest=chain.request()
                .newBuilder()
                .addHeader("x-api-key", API_KEY)
                .build()
            chain.proceed(newRequest)
        }
        .build()
    val productService: ProductService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductService::class.java)
    }
}