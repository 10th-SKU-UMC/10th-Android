package kr.co.umc.nike.data.data_source.local

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.data.data_source.local.room.entity.ProductEntity

interface LocalDataSource {

    fun getAllProducts(): Flow<List<ProductEntity>>

    fun getProductsByWish(isWished: Boolean): Flow<List<ProductEntity>>

    fun getProductsByNew(isNew: Boolean): Flow<List<ProductEntity>>

    fun getProductsByCategory(categoryId: Int): Flow<List<ProductEntity>>

    suspend fun updateWishStatus(id: Int)
}
