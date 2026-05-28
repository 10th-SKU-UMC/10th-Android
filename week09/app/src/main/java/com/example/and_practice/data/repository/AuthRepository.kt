package com.example.and_practice.data.repository

import com.example.and_practice.data.remote.dto.AuthTokenResponseDTO

interface AuthRepository {
    suspend fun login(): Result<AuthTokenResponseDTO>
    suspend fun refreshToken(refreshToken: String): Result<AuthTokenResponseDTO>
    fun logout()
}
