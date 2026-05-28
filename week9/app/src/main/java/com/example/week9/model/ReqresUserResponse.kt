package com.example.week9.model

data class ReqresUserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data:List<ReqresUser>
)
data class ReqresUser(
    val id: Int,
    val email:String,
    val first_name: String,
    val last_name: String,
    val avatar: String
)