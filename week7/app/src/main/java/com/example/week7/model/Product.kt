package com.example.week7.model

import androidx.annotation.DrawableRes

class Product (
    @DrawableRes
    val imageRes: Int,
    val title: String,
    val price: String,
)