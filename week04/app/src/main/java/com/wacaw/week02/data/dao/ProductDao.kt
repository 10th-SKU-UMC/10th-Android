package com.wacaw.week02.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.wacaw.week02.data.entity.ProductEntity

@Dao
interface ProductDao {
    //새 상품을 삽입
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: ProductEntity)

    //상품 정보를 수정
    @Update
    suspend fun updateProduct(product: ProductEntity)

    //특정 상품을 삭제
    @Delete
    suspend fun deleteProduct(product: ProductEntity)

    //모든 상품 데이터
    @Query("SELECT * FROM ProductTable")
    suspend fun getAllProducts(): List<ProductEntity>

    // 특정 카테고리 상품만
    @Query("""
        SELECT ProductTable.* FROM ProductTable 
        INNER JOIN CategoryTable ON ProductTable.category_id = CategoryTable.id 
        WHERE CategoryTable.name = :name
    """)
    suspend fun getProductsByCategoryName(name: String): List<ProductEntity>

    //좋아요 상품만
    @Query("SELECT * FROM ProductTable WHERE isLiked = 1")
    suspend fun getLikedProducts(): List<ProductEntity>

    // 좋아요 상품으로 만들기
    @Query("UPDATE ProductTable SET isLiked = :isLiked WHERE id = :id")
    suspend fun updateLikeStatus(id: Int, isLiked: Boolean)
}