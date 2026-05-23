package com.example.week8.model

import androidx.annotation.DrawableRes

class Product (
    val id: Int = 0,
    @DrawableRes
    val imgRes: Int,
    val title: String,
    val price: String,
    val description: String? = null,
    val category: String? = null,
    val isBestSeller: Boolean = false,
    val isWishlisted: Boolean = false,
    val isInBag: Boolean = false
)