package com.wacaw.week02.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductTable")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, //Primary Key
    val name: String,
    val content: String,
    val image_resource: Int?,
    val price: Int,
    var isLiked: Boolean,
    val category_id: Int? = null
)