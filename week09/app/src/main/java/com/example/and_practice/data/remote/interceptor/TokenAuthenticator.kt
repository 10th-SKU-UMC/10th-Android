package com.example.and_practice.data.remote.interceptor

import com.example.and_practice.data.remote.SessionManager
import com.example.and_practice.data.remote.TokenStorage
import com.example.and_practice.data.repository.AuthRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val authRepository: AuthRepository,
    private val sessionManager: SessionManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        // 저장된 리프레시 토큰 꺼내기, 재발급 못하면 로그인 화면으로 이동
        val refreshToken = TokenStorage.getRefreshToken() ?: run {
            sessionManager.loginEvent.trySend(Unit)
            return null
        }

        // suspend 함수 호출하기 위해 runBlocking, refresh 토큰으로 재발급 시도
        val newToken = runBlocking {
            authRepository.refreshToken(refreshToken).getOrNull()
        }

        // 재발급 실패 시 세션 만료, 로그인 이벤트 전송
        if (newToken == null) {
            sessionManager.loginEvent.trySend(Unit)
            return null
        }

        // 재발급받았으면 access token을 헤어데 넣어서 새 요청으로 request 만들어서 재시도
        return response.request.newBuilder()
            .header("Authorization", "Bearer ${newToken.accessToken}")
            .build()
    }
}
