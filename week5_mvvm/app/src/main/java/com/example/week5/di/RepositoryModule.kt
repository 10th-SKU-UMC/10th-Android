package com.example.week5.di

import com.example.week5.data.repository.LocalProductRepositoryImpl
import com.example.week5.data.repository.RemoteProfileRepositoryImpl
import com.example.week5.domain.repository.LocalProductRepository
import com.example.week5.domain.repository.RemoteProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocalProductRepository(
        impl: LocalProductRepositoryImpl
    ): LocalProductRepository

    @Binds
    @Singleton
    abstract fun bindRemoteProfileRepository(
        impl: RemoteProfileRepositoryImpl
    ): RemoteProfileRepository
}
