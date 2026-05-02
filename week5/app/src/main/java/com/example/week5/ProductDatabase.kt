package com.example.week5

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[ProductEntity::class],
    version=2,
    exportSchema=false
)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile //이 변수의 값은 cpu캐시말고 메인 메모리에서 직접 읽고 쓰겠다.
        private var INSTANCE: ProductDatabase?=null

        fun getDatabase(context: Context): ProductDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    "product_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE=instance
                instance
            }
        }
    }
}

