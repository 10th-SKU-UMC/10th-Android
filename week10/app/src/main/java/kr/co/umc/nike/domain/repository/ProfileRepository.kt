package kr.co.umc.nike.domain.repository

import kr.co.umc.nike.domain.entity.Profile

interface ProfileRepository {
    suspend fun getFollowingUsers(): Result<List<Profile>>
}
