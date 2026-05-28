package com.example.and_practice.data.remote.dto

import com.example.and_practice.data.remote.api.ApiException

// 서버 공통 응답 래퍼 — 모든 API 응답이 이 형태로 내려옴
// HTTP 상태코드와 별개로 body 안의 isSuccess로 성공/실패를 구분하는 서버 구조일 때 사용
data class ApiResponse<T>(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    // 성공 시 실제 데이터, 실패 시 null
    val result: T? = null
)

// isSuccess가 false면 서버 에러코드와 메시지를 ApiException으로 변환해서 던짐
// result가 null이면 데이터 없는 성공으로 간주하지 않고 예외 처리
fun <T> ApiResponse<T>.getOrThrow(): T {
    if (!isSuccess) throw ApiException(code, message)
    return result ?: throw ApiException(code, "result is null")
}

// Repository에서 API 호출을 Result<T>로 감싸는 헬퍼
// runCatching으로 예외를 잡고, getOrThrow()로 isSuccess 검증까지 한번에 처리
suspend fun <T> handleApiResponse(block: suspend () -> ApiResponse<T>): Result<T> =
    runCatching { block().getOrThrow() }
