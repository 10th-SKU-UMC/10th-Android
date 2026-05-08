package com.wacaw.week02.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wacaw.week02.data.dao.CategoryDao
import com.wacaw.week02.data.dao.ProductDao
import com.wacaw.week02.data.entity.CategoryEntity
import com.wacaw.week02.data.entity.ProductEntity

@Database(entities = [ProductEntity::class, CategoryEntity::class], version = 2, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "nike_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}