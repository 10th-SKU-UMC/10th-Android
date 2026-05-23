package com.wontwothree.week07.model

import com.wontwothree.week07.R

data class Product(
    val id: Int,
    val name:String,
    val category:String,
    val price:Int,
    val colors:Int,
    val imageRes:Int,
    val isBestSeller:Boolean=false,
    val isWishList: Boolean=false,
    val isNewArrival:Boolean=false
)

val sampleProduct = listOf(
    Product(1, "Air Jordan XXXVI", "Men's Shoes", 185, 5, R.drawable.img_product_1, isNewArrival = true),
    Product(2, "Nike Air Force 1 '07", "Men's Shoes", 115, 6, R.drawable.img_product_2, isNewArrival = true),
    Product(3, "Nike Everyday Plus Cushioned", "Training Ankle Socks", 10, 5, R.drawable.img_product_3, isWishList = true),
    Product(4, "Nike Elite Crew", "Basketball Socks", 16, 7, R.drawable.img_product_5,isWishList = true),
    Product(5, "Nike Air Force 1 '07", "Women's Shoes", 115, 5, R.drawable.img_product_4, isBestSeller = true, ),
    Product(6, "Jordan ENike Air Force 1 '07ssentials", "Men's Shoes", 115, 2, R.drawable.img_product_6, isBestSeller = true),

    )