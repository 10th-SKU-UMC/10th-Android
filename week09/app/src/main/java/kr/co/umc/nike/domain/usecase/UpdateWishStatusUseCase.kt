package kr.co.umc.nike.domain.usecase

import kr.co.umc.nike.domain.repository.ProductRepository
import javax.inject.Inject

class UpdateWishStatusUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Int) {
        repository.updateWishStatus(id)
    }
}