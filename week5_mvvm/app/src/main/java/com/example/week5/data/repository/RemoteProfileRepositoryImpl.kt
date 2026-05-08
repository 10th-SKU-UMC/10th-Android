package com.example.week5.data.repository

import com.example.week5.data.remote.ProfileService
import com.example.week5.data.remote.UserData
import com.example.week5.domain.repository.RemoteProfileRepository
import javax.inject.Inject

class RemoteProfileRepositoryImpl @Inject constructor(
    private val profileService: ProfileService
) : RemoteProfileRepository {

    override suspend fun getUser(id: Int): Result<UserData> = runCatching {
        val response = profileService.getUser(id)
        val body = response.body()
        if (response.isSuccessful && body != null) {
            body.data
        } else {
            error("getUser failed: code=${response.code()}")
        }
    }

    override suspend fun getUsers(page: Int): Result<List<UserData>> = runCatching {
        val response = profileService.getUsers(page)
        val body = response.body()
        if (response.isSuccessful && body != null) {
            body.data
        } else {
            error("getUsers failed: code=${response.code()}")
        }
    }
}
