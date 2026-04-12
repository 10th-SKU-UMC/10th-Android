package kr.co.umc.nike.presentation.home.mapper

import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.presentation.home.model.NewGood

/**
 * Domain Layer ↔ Presentation Layer 변환 Mapper
 */
object NewGoodMapper {

    // ========== Domain → Presentation Model ==========

    /**
     * ProductSummary → NewGood
     */
    fun ProductSummary.toPresentation(): NewGood =
        NewGood(
            id = id,
            goodImage = productImage,
            goodName = productName,
            goodPrice = "US$$productPrice"
        )

}
