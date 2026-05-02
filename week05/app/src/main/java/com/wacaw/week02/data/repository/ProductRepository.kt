package com.wacaw.week02.data.repository

import com.wacaw.week02.R
import com.wacaw.week02.data.dao.CategoryDao
import com.wacaw.week02.data.dao.ProductDao
import com.wacaw.week02.data.entity.CategoryEntity
import com.wacaw.week02.data.entity.ProductEntity

class ProductRepository (private val productDao: ProductDao,private val categoryDao: CategoryDao){
    suspend fun insertData(){
        val newCategoryId =categoryDao.insertCategory(CategoryEntity(name = "NewArrival"))

        productDao.insertProduct(
            ProductEntity(
                id = 1,
                name = "Air Jordan",
                content = "content1",
                image_resource = R.drawable.img_sample_product_1,
                price = 1,
                isLiked = false,
                category_id = newCategoryId.toInt()
            )
        )
        productDao.insertProduct(
            ProductEntity(
                id = 2,
                name = "Air Jordan2",
                content = "content2",
                image_resource = R.drawable.img_sample_product_2,
                price = 1,
                isLiked = true,
                category_id = newCategoryId.toInt()
            )
        )

        productDao.insertProduct(
            ProductEntity(
                id = 3,
                name = "Nike Everyday Plus Cushioned",
                content = "Training Ankle Socks (6 Pairs)",
                image_resource = R.drawable.image_sample_product_3,
                price = 1,
                isLiked = false,
            )
        )
    }

    suspend fun getAllProducts(): List<ProductEntity> = productDao.getAllProducts()

    suspend fun getLikedProducts(): List<ProductEntity> = productDao.getLikedProducts()

    suspend fun getProductsByCategoryName(name: String): List<ProductEntity> {
        return productDao.getProductsByCategoryName(name)
    }

    suspend fun updateLikeStatus(id: Int, isLiked: Boolean) {
        productDao.updateLikeStatus(id, isLiked)
    }
}