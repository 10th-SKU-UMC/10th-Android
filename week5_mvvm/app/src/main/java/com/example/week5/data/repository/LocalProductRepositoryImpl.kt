package com.example.week5.data.repository

import com.example.week5.data.local.ProductDao
import com.example.week5.data.local.ProductEntity
import com.example.week5.domain.repository.LocalProductRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class LocalProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : LocalProductRepository {

    override fun getAllProductsStream(): Flow<List<ProductEntity>> =
        productDao.getAllProductsFlow()

    override fun getWishlistStream(): Flow<List<ProductEntity>> =
        productDao.getWishlistProductsFlow()

    override fun getInBagStream(): Flow<List<ProductEntity>> =
        productDao.getInBagProductsFlow()

    override fun getProductsByCategoryStream(category: String): Flow<List<ProductEntity>> =
        productDao.getProductsByCategoryFlow(category)

    override suspend fun getAllProductsOnce(): List<ProductEntity> =
        productDao.getAllProducts()

    override suspend fun insert(product: ProductEntity) = productDao.insertProduct(product)
    override suspend fun update(product: ProductEntity) = productDao.updateProduct(product)
    override suspend fun delete(product: ProductEntity) = productDao.deleteProduct(product)

    override suspend fun toggleWishlist(productId: Int, isWishlisted: Boolean) =
        productDao.updateWishlistState(productId, isWishlisted)

    override suspend fun toggleBag(productId: Int, isInBag: Boolean) =
        productDao.updateBagState(productId, isInBag)

    override suspend fun seedIfEmpty(seed: List<ProductEntity>) {
        if (productDao.getAllProducts().isEmpty()) {
            seed.forEach { productDao.insertProduct(it) }
        }
    }
}
