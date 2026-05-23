package kr.co.umc.nike.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.umc.nike.data.repositoryimpl.ProductRepositoryImpl
import kr.co.umc.nike.data.repositoryimpl.ProfileRepositoryImpl
import kr.co.umc.nike.domain.repository.ProductRepository
import kr.co.umc.nike.domain.repository.ProfileRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        impl: ProductRepositoryImpl
    ): ProductRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepository(
        impl: ProfileRepositoryImpl
    ): ProfileRepository

}