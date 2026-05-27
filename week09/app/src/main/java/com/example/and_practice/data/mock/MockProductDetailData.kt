package com.example.and_practice.data.mock

data class MockProductDetailData(
    val id: Int,
    val category: String = "",
    val name: String = "",
    val price: Int,
    val productImage: String? = null,
    val content: String = "",
    val shown: String = "",
    val styleNumber: String = ""
)
