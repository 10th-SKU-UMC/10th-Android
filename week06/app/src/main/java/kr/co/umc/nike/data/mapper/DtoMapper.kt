package kr.co.umc.nike.data.mapper

import kr.co.umc.nike.data.data_source.local.room.entity.ProductEntity
import kr.co.umc.nike.data.model.response.User
import kr.co.umc.nike.domain.entity.ProductCategory
import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.presentation.profile.model.Profile

/**
 * Data Layer ↔ Domain Layer 변환 Mapper
 */
object DtoMapper {

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

    /**
     * User -> Profile
     */
    fun User.toProfile(): Profile {
        return Profile(
            id = id,
            email = email,
            name = "$firstName $lastName",
            avatar = avatar
        )
    }


}