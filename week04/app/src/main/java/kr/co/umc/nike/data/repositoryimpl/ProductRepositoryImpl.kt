package kr.co.umc.nike.data.repositoryimpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kr.co.umc.nike.data.data_source.local.LocalDataSource
import kr.co.umc.nike.data.mapper.ProductMapper.toDomain
import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : ProductRepository {
    override fun getAllProducts(): Flow<List<ProductSummary>> {
        return localDataSource.getAllProducts()
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByWish(isWished: Boolean): Flow<List<ProductSummary>> {
        return localDataSource.getProductsByWish(isWished)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByNew(isNew: Boolean): Flow<List<ProductSummary>> {
        return localDataSource.getProductsByNew(isNew)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override fun getProductsByCategory(categoryId: Int): Flow<List<ProductSummary>> {
        return localDataSource.getProductsByCategory(categoryId)
            .map { entityList ->
                entityList.map { it.toDomain() }
            }
    }

    override suspend fun updateWishStatus(id: Int) {
        withContext(Dispatchers.IO) {
            localDataSource.updateWishStatus(id)
        }
    }

}
