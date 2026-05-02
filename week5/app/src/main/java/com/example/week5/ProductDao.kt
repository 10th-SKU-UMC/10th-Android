package com.example.week5

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: ProductEntity)
    @Update
    fun updateProduct(product: ProductEntity)
    @Delete
    fun deleteProduct(product: ProductEntity)
    //모든 상품 조회
    @Query("SELECT * FROM ProductTable")
    fun getAllProducts():List<ProductEntity>
    //베스트셀러 상품 조회
    @Query("Select * From ProductTable WHERE isBestSeller=1")
    fun getBestSellerProducts(): List<ProductEntity>
    //위시리스트 상품 조회
    @Query("SELECT * FROM ProductTable WHERE isWishlisted=1")
    fun getWishlistProducts(): List<ProductEntity>
    //장바구니 상품 조회
    @Query("SELECT * FROM ProductTable WHERE isInBag=1")
    fun getInBagProducts(): List<ProductEntity>
    //상품 하나 조회
    @Query("SELECT * FROM ProductTable WHERE id = :productId")
    fun getProductId(productId: Int): ProductEntity?
    //위시리스트 상태 바꿈
    @Query("UPDATE ProductTable SET isWishlisted = :isWishlisted WHERE id = :productId")
    fun updateWishlistState(productId: Int, isWishlisted: Boolean)
    //장바구니 상태 변경
    @Query("UPDATE ProductTable SET isInBag = :isInBag WHERE id = :productId")
    fun updateBagState(productId: Int, isInBag: Boolean)
    //카테고리별 상품 조회
    @Query("SELECT * FROM ProductTable WHERE category = :category")
    fun getProductsByCategory(category: String): List<ProductEntity>
}