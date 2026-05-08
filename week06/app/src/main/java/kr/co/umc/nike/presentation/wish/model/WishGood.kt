package kr.co.umc.nike.presentation.wish.model

import androidx.annotation.DrawableRes

data class WishGood(
    val id: Int,
    @field:DrawableRes val goodImage: Int,
    val goodName: String,
    val description: String? = null,
    val colorDescription: String? = null,
    val goodPrice: String,
)
