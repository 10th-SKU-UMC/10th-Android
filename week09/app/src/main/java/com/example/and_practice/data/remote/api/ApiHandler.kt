package com.example.and_practice.data.remote.api

import java.io.IOException
import java.net.SocketTimeoutException
import retrofit2.HttpException

/**
 * ViewModel에서 예외를 그대로 보여주도록 처리하는 확장함수
 * Throwable -> ApiError로 변환한다
 */
fun Throwable.toApiError(): ApiError {
    return when (this) {

        // 1단계: HTTP 상태코드로 1차 분류
        is HttpException -> when (code()) {
            400 -> ApiError.BadRequest()
            401 -> ApiError.Unauthorized()
            403 -> ApiError.Forbidden()
            404 -> ApiError.NotFound()
            409 -> ApiError.Conflict()
            in 500..599 -> ApiError.ServerError()
            else -> ApiError.Unknown()
        }

        // 2단계: 서버 커스텀 에러코드로 세부 분류
        is ApiException -> when (errorCode) {
            ErrorCode.INVALID_REQUEST,
            ErrorCode.INVALID_FORMAT,
            ErrorCode.INVALID_DATE -> ApiError.BadRequest(message ?: "입력값을 다시 확인해주세요.")
            ErrorCode.UNAUTHORIZED -> ApiError.Unauthorized()
            ErrorCode.FORBIDDEN -> ApiError.Forbidden()
            ErrorCode.NOT_FOUND -> ApiError.NotFound()
            ErrorCode.DUPLICATE_RESOURCE,
            ErrorCode.CONCURRENT_MODIFICATION -> ApiError.Conflict(message ?: "이미 존재하는 데이터입니다.")
            ErrorCode.INTERNAL_SERVER_ERROR -> ApiError.ServerError()
            else -> ApiError.Unknown(message ?: "문제가 발생했습니다. 다시 시도해주세요.")
        }

        // 네트워크 레벨 실패 — HTTP 응답 자체가 없는 경우
        is SocketTimeoutException, is IOException -> ApiError.NetworkError

        // 위 케이스에 해당하지 않는 모든 예외
        else -> ApiError.Unknown(message ?: "문제가 발생했습니다. 다시 시도해주세요.")
    }
}
