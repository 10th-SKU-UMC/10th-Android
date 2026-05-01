package kr.co.umc.nike.data.repositoryimpl

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.api.ProfileApiService
import kr.co.umc.nike.data.mapper.DtoMapper.toProfile
import kr.co.umc.nike.data.util.toResult
import kr.co.umc.nike.domain.repository.ProfileRepository
import kr.co.umc.nike.presentation.profile.model.Profile
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApiService: ProfileApiService
): ProfileRepository {
    override suspend fun getFollowingUsers(): Result<List<Profile>> {
        return try {
            profileApiService.getFollowingUsers()
                .toResult { userList -> // userList의 원소를 Profile로 변환한 리스트 반환
                    userList.map { it.toProfile() }
                }
        } catch(e: Exception) {
            Result.failure(e)
        }
    }
}