package kr.co.umc.nike.presentation.mapper

import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.presentation.home.model.NewGood
import kr.co.umc.nike.presentation.wish.model.WishGood

/**
 * Domain Layer ↔ Presentation Layer 변환 Mapper
 */
object PresentationMapper {

    // ========== Domain → Presentation Model ==========

    /**
     * ProductSummary → NewGood
     */
    fun ProductSummary.toNewGood(): NewGood =
        NewGood(
            id = id,
            goodImage = productImage,
            goodName = productName,
            goodPrice = "US$$productPrice"
        )

    /**
     * ProductSummary → Good
     */
    fun ProductSummary.toGood(): Good =
        Good(
            id = id,
            goodImage = productImage,
            isWished = isWished,
            isBestSeller = isBestSeller,
            goodName = productName,
            goodDescription = productDescription,
            colorDescription = "$colorNum Colours",
            goodPrice = "US$$productPrice"
        )

    fun ProductSummary.toWishGood(): WishGood =
        WishGood(
            id = id,
            goodImage = productImage,
            goodName = productName,
            description = productDescription,
            colorDescription = "$colorNum Colours",
            goodPrice = "US$$productPrice"
        )

}