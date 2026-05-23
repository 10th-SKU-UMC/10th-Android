package com.example.week8.model

import com.example.week8.R

val sampleProducts=listOf(
    Product(
        id=1,
        imgRes= R.drawable.airjordan_xxxvi,
        title= "Air Jordan XXXVI",
        price="US$185",
        category="Shoes"
    ),
    Product(
        id=2,
        imgRes=R.drawable.airjordan1mid,
        title="Air Jordan 1 Mid",
        price="US$125",
        isWishlisted = true
    ),
    Product(
        id=3,
        imgRes=R.drawable.nikeairforce,
        title="Nike Air Force 1 '07",
        price="US$115",
        category="Shoes",
        isBestSeller = true,
        description = "Women's Shoes \n5 Colours"
    ),
    Product(
        id=4,
        imgRes=R.drawable.nikeeverydayplus,
        title="Nike Everyday Plus Cushioned",
        price="US$10",
        description = "Training Ankle Socks(6 Pairs)"
    ),
    Product(
        id=5,
        imgRes=R.drawable.elitecrew,
        title="Nike Elite Crew",
        price="US$16",
        description = "Basketball Socks \n7 Colors"
    ),
    Product(
        id=6,
        imgRes = R.drawable.jordaenikeairforce,
        title="Jordan Enike Air Force 1 '07ssentials",
        description = "Mes's Shoes \n2 Colours",
        price="US$115",
        isBestSeller = true
    )

)