package com.example.and_practice.data.remote.di

import com.example.and_practice.data.repository.AuthRepository
import com.example.and_practice.data.repository.AuthRepositoryImpl
import com.example.and_practice.data.repository.ProfileRepository
import com.example.and_practice.data.repository.ProfileRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// @Binds — 인터페이스 요청 시 어떤 구현체를 쓸지 Hilt에 알려주는 모듈
// @Provides와 달리 구현 코드 없이 바인딩만 선언 → 컴파일 효율적
// abstract class여야 @Binds 사용 가능
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository
}
