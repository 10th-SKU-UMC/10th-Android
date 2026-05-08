package com.wacaw.week02.di

import android.content.Context
import com.wacaw.week02.data.dao.CategoryDao
import com.wacaw.week02.data.dao.ProductDao
import com.wacaw.week02.data.database.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)  // 앱 전체에서 하나만 유지
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ProductDatabase {
        return ProductDatabase.getInstance(context)
    }

    @Provides
    fun provideProductDao(db: ProductDatabase): ProductDao {
        return db.productDao()
    }

    @Provides
    fun provideCategoryDao(db: ProductDatabase): CategoryDao {
        return db.categoryDao()
    }
}