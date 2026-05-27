package com.example.and_practice.data.remote.interceptor

import com.example.and_practice.data.remote.TokenStorage
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val path = originalRequest.url.encodedPath
        val accessToken = TokenStorage.getAccessToken()

        // 로그인,리프레시 경로이거나 토큰이 없으면 그대로 통과
        if (
            accessToken.isNullOrBlank() ||
            path == "/api/v1/auth/dev-login" ||
            path == "/api/v1/auth/refresh"
        ) {
            return chain.proceed(originalRequest)
        }

        val authenticatedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()

        return chain.proceed(authenticatedRequest)
    }
}
