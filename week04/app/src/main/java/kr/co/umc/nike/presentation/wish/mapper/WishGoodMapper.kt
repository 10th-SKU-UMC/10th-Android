package kr.co.umc.nike.presentation.wish.mapper

import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.presentation.wish.model.WishGood

/**
 * Domain Layer ↔ Presentation Layer 변환 Mapper
 */
object WishGoodMapper {

    // ========== Domain → Presentation Model ==========

    fun ProductSummary.toPresentation(): WishGood =
        WishGood(
            id = id,
            goodImage = productImage,
            goodName = productName,
            description = productDescription,
            colorDescription = "$colorNum Colours",
            goodPrice = "US$$productPrice"
        )
}
