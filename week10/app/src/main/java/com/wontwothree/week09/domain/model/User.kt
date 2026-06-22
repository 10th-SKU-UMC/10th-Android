package com.wontwothree.week09.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val email:String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar:String
)

// 단일 조회
data class UserResponse(
    val data:User
)

// 목록 조회
data class UsersResponse(
    val data:List<User>
)