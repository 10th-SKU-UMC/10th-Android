package com.example.week5

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UserData>
)

data class UserSingleResponse(
    val data: UserData,
    val support: SupportData?
)

data class SupportData(
    val url: String,
    val text: String
)

data class UserData(
    val id: Int,
    val email: String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)
