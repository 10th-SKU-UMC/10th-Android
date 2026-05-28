package com.example.and_practice.data.repository

import com.example.and_practice.data.remote.dto.MeProfileResponseDTO
import com.example.and_practice.data.remote.dto.UpdateMyProfileRequestDTO

interface ProfileRepository {
    suspend fun getMyProfile(): Result<MeProfileResponseDTO>
    suspend fun updateProfile(request: UpdateMyProfileRequestDTO): Result<Unit>
}
