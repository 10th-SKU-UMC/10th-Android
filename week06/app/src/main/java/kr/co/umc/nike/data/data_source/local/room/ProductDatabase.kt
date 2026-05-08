package kr.co.umc.nike.data.data_source.local.room

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.umc.nike.R
import kr.co.umc.nike.data.data_source.local.room.dao.CategoryDao
import kr.co.umc.nike.data.data_source.local.room.dao.ProductDao
import kr.co.umc.nike.data.data_source.local.room.entity.CategoryEntity
import kr.co.umc.nike.data.data_source.local.room.entity.ProductEntity
import java.util.concurrent.Executors

@Database(entities = [ProductEntity::class, CategoryEntity::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

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
                    "nike_database" // DB 파일 이름
                ).addCallback(object : RoomDatabase.Callback() { // 더미데이터 삽입 콜백 추가

                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        CoroutineScope(Dispatchers.IO).launch{
                            INSTANCE?.let {
                                val productDao = it.productDao()
                                val categoryDao = it.categoryDao()

                                categoryDao.apply {
                                    insertCategory(CategoryEntity(1, "Tops & T-Shirts"))
                                    insertCategory(CategoryEntity(2, "Shoes"))
                                    insertCategory(CategoryEntity(3, "Socks"))
                                }

                                productDao.apply {
                                    insertProduct(
                                        ProductEntity(
                                            name = "Air Jordan XXXVI",
                                            content = "a",
                                            productDescription = "Men's Shoes",
                                            colorNum = 3,
                                            productImage = R.drawable.img_air_jordan,
                                            price = 300,
                                            isWished = false,
                                            isNew = true,
                                            isBestSeller = false,
                                            categoryId = 2
                                        )
                                    )
                                    insertProduct(
                                        ProductEntity(
                                            name = "Nike Air Force 1 '07",
                                            content = "b",
                                            productDescription = "Men's Shoes",
                                            colorNum = 3,
                                            productImage = R.drawable.img_air_force,
                                            price = 115,
                                            isWished = false,
                                            isNew = true,
                                            isBestSeller = true,
                                            categoryId = 2
                                        )
                                    )
                                    insertProduct(
                                        ProductEntity(
                                            name = "Nike Everyday Plus Cushioned",
                                            content = "c",
                                            productDescription = "Training Ankle Socks (6 Pairs)",
                                            colorNum = 5,
                                            productImage = R.drawable.img_mid_socks,
                                            price = 10,
                                            isWished = true,
                                            isNew = false,
                                            isBestSeller = false,
                                            categoryId = 3
                                        )
                                    )
                                    insertProduct(
                                        ProductEntity(
                                            name = "Nike Elite Crew",
                                            content = "d",
                                            productDescription = "Basketball Socks",
                                            colorNum = 7,
                                            productImage = R.drawable.img_basketball_socks,
                                            price = 16,
                                            isWished = false,
                                            isNew = false,
                                            isBestSeller = false,
                                            categoryId = 3
                                        )
                                    )
                                    insertProduct(
                                        ProductEntity(
                                            name = "Jordan ENike Air Force 1 '07essentials",
                                            content = "e",
                                            productDescription = "Men's Shoes",
                                            colorNum = 2,
                                            productImage = R.drawable.img_air_force_essential,
                                            price = 115,
                                            isWished = false,
                                            isNew = false,
                                            isBestSeller = true,
                                            categoryId = 2
                                        )
                                    )
                                }
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}