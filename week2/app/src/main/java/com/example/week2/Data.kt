package com.example.week2

data class Data (
    val imgRes: Int,
    val title: String,
    val price: String,
    val description: String?=null,
    val isBestSeller: Boolean?=false,
)