package kr.co.umc.nike.data.mapper

import kr.co.umc.nike.data.data_source.local.room.entity.ProductEntity
import kr.co.umc.nike.domain.entity.ProductCategory
import kr.co.umc.nike.domain.entity.ProductSummary

/**
 * Data Layer ↔ Domain Layer 변환 Mapper
 */
object ProductMapper {

    // ========== Entity → Domain ==========

    /**
     * ProductEntity → ProductSummary
     */
    fun ProductEntity.toDomain(): ProductSummary {
        return ProductSummary(
            id = id,
            productName = name,
            category = ProductCategory.from(categoryId),
            productDescription = productDescription,
            colorNum = colorNum,
            productImage = productImage,
            isWished = isWished,
            isNew = isNew,
            isBestSeller = isBestSeller,
            productPrice = price
        )
    }

}