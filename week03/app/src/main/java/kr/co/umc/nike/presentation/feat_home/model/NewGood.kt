package kr.co.umc.nike.presentation.feat_home.model

import androidx.annotation.DrawableRes

data class NewGood(
    @field:DrawableRes val goodImage: Int,
    val goodName: String,
    val goodPrice: String
)
