package kr.co.umc.nike.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.umc.nike.data.data_source.local.room.ProductDatabase
import kr.co.umc.nike.data.data_source.local.room.dao.CategoryDao
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomDBModule {
    @Singleton
    @Provides
    fun provideProductDatabase(@ApplicationContext context: Context): ProductDatabase {
        return ProductDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideProductDao(db: ProductDatabase): ProductDao {
        return db.productDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(db: ProductDatabase): CategoryDao {
        return db.categoryDao()
    }
}