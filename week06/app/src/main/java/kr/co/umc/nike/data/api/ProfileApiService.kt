package kr.co.umc.nike.data.api

import kr.co.umc.nike.data.model.response.ResReqResponse
import kr.co.umc.nike.data.model.response.User
import retrofit2.http.GET

interface ProfileApiService {
    @GET("users")
    suspend fun getFollowingUsers(): ResReqResponse<List<User>>
}