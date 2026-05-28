package com.example.and_practice.data.remote.api

/**
 * HTTP 예외에 따른 메세지 매핑용 sealed class
 */
sealed class ApiError {
    abstract val defaultMessage: String

    // 400 — 요청 파라미터 형식 오류
    data class BadRequest(override val defaultMessage: String = "입력값을 다시 확인해주세요.") : ApiError()

    // 401 — 토큰 없음 또는 만료
    data class Unauthorized(override val defaultMessage: String = "로그인이 필요합니다.") : ApiError()

    // 403 — 권한 없는 리소스 접근
    data class Forbidden(override val defaultMessage: String = "이 기능에 접근할 수 없습니다.") : ApiError()

    // 404 — 존재하지 않는 리소스 요청
    data class NotFound(override val defaultMessage: String = "요청한 데이터를 찾을 수 없습니다.") : ApiError()

    // 409 — 중복 데이터 또는 동시 수정 충돌
    data class Conflict(override val defaultMessage: String = "이미 존재하는 데이터입니다.") : ApiError()

    // 500번대 — 서버 내부 오류
    data class ServerError(override val defaultMessage: String = "서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요.") : ApiError()

    // 인터넷 연결 없음 / DNS 실패 / 타임아웃 등 네트워크 레벨 실패
    // object = 상태가 없는 싱글턴, 메시지가 항상 동일하므로 data class 불필요
    object NetworkError : ApiError() {
        override val defaultMessage = "인터넷 연결을 확인해주세요."
    }

    // 위 케이스에 해당하지 않는 예외 처리용 폴백
    data class Unknown(override val defaultMessage: String = "문제가 발생했습니다. 다시 시도해주세요.") : ApiError()
}
