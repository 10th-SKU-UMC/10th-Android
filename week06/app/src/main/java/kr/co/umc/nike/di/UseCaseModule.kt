package kr.co.umc.nike.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.umc.nike.domain.repository.ProductRepository
import kr.co.umc.nike.domain.usecase.GetAllProductsUseCase
import kr.co.umc.nike.domain.usecase.GetNewProductsUseCase
import kr.co.umc.nike.domain.usecase.GetWishProductsUseCase
import kr.co.umc.nike.domain.usecase.UpdateWishStatusUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllProductsUseCase(
        repository: ProductRepository
    ): GetAllProductsUseCase = GetAllProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetNewProductsUseCase(
        repository: ProductRepository
    ): GetNewProductsUseCase = GetNewProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetWishProductsUseCase(
        repository: ProductRepository
    ): GetWishProductsUseCase = GetWishProductsUseCase(repository)

    @Provides
    @Singleton
    fun provideUpdateWishStateUseCase(
        repository: ProductRepository
    ): UpdateWishStatusUseCase = UpdateWishStatusUseCase(repository)

}