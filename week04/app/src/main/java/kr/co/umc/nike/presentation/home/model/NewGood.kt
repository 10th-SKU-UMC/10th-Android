package kr.co.umc.nike.presentation.home.model

import androidx.annotation.DrawableRes

data class NewGood(
    val id: Int,
    @field:DrawableRes val goodImage: Int,
    val goodName: String,
    val goodPrice: String
)
