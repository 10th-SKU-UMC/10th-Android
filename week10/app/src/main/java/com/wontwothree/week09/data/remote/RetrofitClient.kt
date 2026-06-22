package com.wontwothree.week09.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{
    private const val BASE_URL = "https://reqres.in/"
    private const val API_KEY = "free_user_3EHgMIcuVfjS6umsUEtR6bPW1TU"

    private val headerInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .header("x-api-key", API_KEY)
            .build()
        chain.proceed(request)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .build()

    val instance: UserApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }
}