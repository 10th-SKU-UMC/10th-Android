package com.example.week4

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="ProductTable")
data class ProductEntity(
    @PrimaryKey (autoGenerate=true)
    val id: Int=0,
    val imgRes:Int,
    val title: String,
    val price: String,
    val description: String?=null,
    val category: String?=null,
    val isBestSeller: Boolean=false,
    val isWishlisted: Boolean=false,
    val isInBag: Boolean=false
)