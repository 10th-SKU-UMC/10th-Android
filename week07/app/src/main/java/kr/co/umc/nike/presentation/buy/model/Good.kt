package kr.co.umc.nike.presentation.buy.model

import androidx.annotation.DrawableRes

data class Good(
    val id: Int,
    @field:DrawableRes val goodImage: Int,
    val isWished: Boolean,
    val isBestSeller: Boolean,
    val goodName: String,
    val goodDescription: String,
    val colorDescription: String,
    val goodPrice: String
)
