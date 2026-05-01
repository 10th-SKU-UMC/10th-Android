package kr.co.umc.nike.data.data_source.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.data_source.local.room.entity.ProductEntity

@Dao
interface ProductDao {
    //새 상품을 삽입
    @Insert
    suspend fun insertProduct(product: ProductEntity)

    //상품 정보를 수정
    @Update
    suspend fun updateProduct(product: ProductEntity)

    //특정 상품을 삭제
    @Delete
    suspend fun deleteProduct(product: ProductEntity)

    //모든 상품 데이터를 가져오는 쿼리
    @Query("SELECT * FROM ProductTable")
    fun getAllProducts(): Flow<List<ProductEntity>>

    //위시 여부에 따라 상품 데이터를 가져오는 쿼리
    @Query("SELECT * FROM ProductTable WHERE isWished = :isWished")
    fun getProductsByWish(isWished: Boolean): Flow<List<ProductEntity>>

    //새 상품인지 여부에 따라 데이터를 가져오는 쿼리
    @Query("SELECT * FROM ProductTable WHERE isNew = :isNew")
    fun getProductsByNew(isNew: Boolean): Flow<List<ProductEntity>>

    //특정 카테고리의 상품만 가져오는 쿼리
    @Query("SELECT * FROM ProductTable WHERE categoryId = :categoryId")
    fun getProductsByCategory(categoryId: Int): Flow<List<ProductEntity>>

    //상품의 위시 여부를 바꿈
    @Query("UPDATE ProductTable SET isWished = NOT isWished WHERE id = :id") // 이거 좋은 쿼리문인가..?
    fun updateWishStatus(id: Int)

}