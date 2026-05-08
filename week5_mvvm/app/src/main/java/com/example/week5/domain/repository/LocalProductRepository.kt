package com.example.week5.domain.repository

import com.example.week5.data.local.ProductEntity
import kotlinx.coroutines.flow.Flow

interface LocalProductRepository {
    fun getAllProductsStream(): Flow<List<ProductEntity>>
    fun getWishlistStream(): Flow<List<ProductEntity>>
    fun getInBagStream(): Flow<List<ProductEntity>>
    fun getProductsByCategoryStream(category: String): Flow<List<ProductEntity>>

    suspend fun getAllProductsOnce(): List<ProductEntity>
    suspend fun insert(product: ProductEntity)
    suspend fun update(product: ProductEntity)
    suspend fun delete(product: ProductEntity)
    suspend fun toggleWishlist(productId: Int, isWishlisted: Boolean)
    suspend fun toggleBag(productId: Int, isInBag: Boolean)

    suspend fun seedIfEmpty(seed: List<ProductEntity>)
}
