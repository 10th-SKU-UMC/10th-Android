package kr.co.umc.nike.domain.repository

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.presentation.profile.model.Profile

interface ProfileRepository {
    suspend fun getFollowingUsers(): Result<List<Profile>>
}
