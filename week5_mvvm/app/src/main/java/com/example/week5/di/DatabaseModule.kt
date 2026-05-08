package com.example.week5.di

import android.content.Context
import androidx.room.Room
import com.example.week5.data.local.ProductDao
import com.example.week5.data.local.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // 앱 전체에서 하나만 유지
object DatabaseModule {

    @Provides
    @Singleton // ← DB는 무조건 하나만! 호출마다 새로 만들면 안 됨
    fun provideProductDatabase(
        @ApplicationContext context: Context
    ): ProductDatabase {
        return Room.databaseBuilder(
            context,
            ProductDatabase::class.java,
            "product_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideProductDao(database: ProductDatabase): ProductDao = database.productDao()
}
