package com.example.and_practice.data.remote.api

/**
 * 서버의 커스텀 에러 코드 모음
 */
object ErrorCode {
    // 400 — 잘못된 요청 세부 분류
    const val INVALID_REQUEST = "COMMON400_1"   // 필드 검증 실패
    const val INVALID_FORMAT  = "COMMON400_2"   // 형식 불일치
    const val INVALID_DATE    = "COMMON400_3"   // 날짜 범위 오류

    // 401 — 인증 실패
    const val UNAUTHORIZED = "COMMON401_1"      // 토큰 없음 또는 만료

    // 403 — 인가 실패
    const val FORBIDDEN = "COMMON403_1"         // 권한 없는 접근

    // 404 — 리소스 없음
    const val NOT_FOUND = "COMMON404_1"

    // 409 — 충돌
    const val DUPLICATE_RESOURCE     = "COMMON409_1"  // 이미 존재하는 데이터
    const val CONCURRENT_MODIFICATION = "COMMON409_2" // 동시 수정 충돌

    // 500 — 서버 내부 오류
    const val INTERNAL_SERVER_ERROR = "COMMON500_1"
}

/**
 * 서버 에러코드와 메시지를 담는 커스텀 예외
 */
class ApiException(
    val errorCode: String,
    override val message: String
) : RuntimeException(message)
