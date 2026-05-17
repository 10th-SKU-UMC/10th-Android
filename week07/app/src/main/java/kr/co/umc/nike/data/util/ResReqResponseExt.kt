package kr.co.umc.nike.data.util

import kr.co.umc.nike.data.model.response.ResReqResponse

/**
 * ResReqResponse를 Result로 변환하는 확장 함수
 * ResReq응답은 항상 성공하므로 Result.success로 감싸서 반환
 *
 * @receiver
 * @param T 응답 중 data필드의 타입
 * @param R Result에 들어갈 value의 Type
 * @param T -> R 변환 로직
 *
 * @return 변환된 Result 객체
 *
 */
inline fun <T, R> ResReqResponse<T>.toResult(
    transform: (T) -> R
): Result<R> {
    return Result.success(transform(this.data))
}
