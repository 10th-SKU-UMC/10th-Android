package com.example.and_practice.data.repository

import com.example.and_practice.data.remote.TokenStorage
import com.example.and_practice.data.remote.api.AuthApi
import com.example.and_practice.data.remote.dto.AuthTokenResponseDTO
import com.example.and_practice.data.remote.dto.LoginRequestDTO
import com.example.and_practice.data.remote.dto.RefreshTokenRequestDTO
import com.example.and_practice.data.remote.dto.handleApiResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
) : AuthRepository {

    companion object {
        private const val MOCK_DEV_EMAIL = "dev-user@project.local"
        private const val MOCK_DEV_PASSWORD = "dev1234!"
    }

    override suspend fun login(): Result<AuthTokenResponseDTO> {
        return handleApiResponse {
            authApi.devLogin(LoginRequestDTO(MOCK_DEV_EMAIL, MOCK_DEV_PASSWORD))
        }.also { result ->
            result.onSuccess { token ->
                TokenStorage.saveTokens(token.accessToken, token.refreshToken)
            }
        }
    }

    override suspend fun refreshToken(refreshToken: String): Result<AuthTokenResponseDTO> {
        return handleApiResponse {
            authApi.refresh(RefreshTokenRequestDTO(refreshToken))
        }.also { result ->
            result.onSuccess { token ->
                TokenStorage.saveTokens(token.accessToken, token.refreshToken)
            }
        }
    }

    override fun logout() {
        TokenStorage.clear()
    }
}
