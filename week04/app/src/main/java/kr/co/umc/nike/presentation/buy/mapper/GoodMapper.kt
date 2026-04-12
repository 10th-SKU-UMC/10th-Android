package kr.co.umc.nike.presentation.buy.mapper

import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.presentation.buy.model.Good

/**
 * Domain Layer ↔ Presentation Layer 변환 Mapper
 */
object GoodMapper {

    // ========== Domain → Presentation Model ==========

    /**
     * ProductSummary → Good
     */
    fun ProductSummary.toPresentation(): Good =
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

}