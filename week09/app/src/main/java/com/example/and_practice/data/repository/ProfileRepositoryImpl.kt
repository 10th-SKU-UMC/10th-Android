package com.example.and_practice.data.repository

import com.example.and_practice.data.remote.api.ProfileApi
import com.example.and_practice.data.remote.dto.MeProfileResponseDTO
import com.example.and_practice.data.remote.dto.UpdateMyProfileRequestDTO
import com.example.and_practice.data.remote.dto.handleApiResponse
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileApi: ProfileApi
) : ProfileRepository {

    override suspend fun getMyProfile(): Result<MeProfileResponseDTO> =
        handleApiResponse { profileApi.getMyProfile() }

    override suspend fun updateProfile(request: UpdateMyProfileRequestDTO): Result<Unit> =
        handleApiResponse { profileApi.updateProfile(request) }
}
