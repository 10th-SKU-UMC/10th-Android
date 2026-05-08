package com.example.week5.domain.repository

import com.example.week5.data.remote.UserData

interface RemoteProfileRepository {
    suspend fun getUser(id: Int): Result<UserData>
    suspend fun getUsers(page: Int): Result<List<UserData>>
}
