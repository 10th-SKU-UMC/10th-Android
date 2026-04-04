package kr.co.umc.nike.presentation.feat_wish.model

import androidx.annotation.DrawableRes

data class WishGood(
    @field:DrawableRes val goodImage: Int,
    val goodName: String,
    val description: String? = null,
    val colorDescription: String? = null,
    val goodPrice: String,
)
