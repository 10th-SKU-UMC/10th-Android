package kr.co.umc.nike.domain.entity

/**
 * 상품 상세 정보 도메인 엔티티
 */
//data class Product(
//    val
//)

/**
 * 상품 간단 정보 도메인 엔티티(목록용)
 */
data class ProductSummary(
    val id: Int,
    val productName: String,
    val category: ProductCategory,
    val productDescription: String,
    val colorNum: Int,
    val productImage: Int,
    val isWished: Boolean,
    val isNew: Boolean,
    val isBestSeller: Boolean,
    val productPrice: Int
)

enum class ProductCategory(val categoryId: Int, val displayName: String) {
    TOPS(1, "Tops & T-Shirts"),
    SHOES(2, "Shoes"),
    SOCKS(3, "Socks");

    companion object {
        fun from(categoryId: Int): ProductCategory {
            return entries.find { it.categoryId == categoryId }
                ?: throw IllegalArgumentException("UnKnown ProductCategory! categoryId: $categoryId")
        }

        fun fromDisplayName(displayName: String): ProductCategory {
            return entries.find { it.displayName == displayName }
                ?: throw IllegalArgumentException("UnKnown ProductCategory! displayName: $displayName")
        }
    }
}




