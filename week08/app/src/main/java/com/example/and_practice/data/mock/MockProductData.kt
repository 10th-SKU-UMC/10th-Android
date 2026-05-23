package com.example.and_practice.data.mock

data class MockProductData(
    val id: Int,
    val name: String,
    val price: Int,
    val badge: MockBadgeType? = null,
    val category: String? = null,
    val subName: String? = null,
    val colorCount: Int? = null,
    val productImage: String? = null,
    val content: String? = null,
    val shown: String? = null,
    val styleNumber: String? = null
)
