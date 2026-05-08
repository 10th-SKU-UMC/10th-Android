package com.example.week5.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: ProductEntity)

    @Update
    suspend fun updateProduct(product: ProductEntity)

    @Delete
    suspend fun deleteProduct(product: ProductEntity)

    // 모든 상품 조회 (Flow: DB 변화를 자동 구독)
    @Query("SELECT * FROM ProductTable")
    fun getAllProductsFlow(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM ProductTable")
    suspend fun getAllProducts(): List<ProductEntity>

    // 베스트셀러 상품 조회
    @Query("SELECT * FROM ProductTable WHERE isBestSeller = 1")
    suspend fun getBestSellerProducts(): List<ProductEntity>

    // 위시리스트 상품 조회 (Flow)
    @Query("SELECT * FROM ProductTable WHERE isWishlisted = 1")
    fun getWishlistProductsFlow(): Flow<List<ProductEntity>>

    // 장바구니 상품 조회
    @Query("SELECT * FROM ProductTable WHERE isInBag = 1")
    fun getInBagProductsFlow(): Flow<List<ProductEntity>>

    // 상품 하나 조회
    @Query("SELECT * FROM ProductTable WHERE id = :productId")
    suspend fun getProductById(productId: Int): ProductEntity?

    // 위시리스트 상태 토글
    @Query("UPDATE ProductTable SET isWishlisted = :isWishlisted WHERE id = :productId")
    suspend fun updateWishlistState(productId: Int, isWishlisted: Boolean)

    // 장바구니 상태 변경
    @Query("UPDATE ProductTable SET isInBag = :isInBag WHERE id = :productId")
    suspend fun updateBagState(productId: Int, isInBag: Boolean)

    // 카테고리별 상품 조회 (Flow)
    @Query("SELECT * FROM ProductTable WHERE category = :category")
    fun getProductsByCategoryFlow(category: String): Flow<List<ProductEntity>>
}
