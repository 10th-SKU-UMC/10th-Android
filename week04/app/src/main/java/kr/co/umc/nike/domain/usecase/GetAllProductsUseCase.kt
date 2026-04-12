package kr.co.umc.nike.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.co.umc.nike.domain.entity.ProductSummary
import kr.co.umc.nike.domain.repository.ProductRepository
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<List<ProductSummary>> {
        return repository.getAllProducts()
    }
}