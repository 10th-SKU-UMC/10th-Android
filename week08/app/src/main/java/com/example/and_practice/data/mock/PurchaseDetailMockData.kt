package com.example.and_practice.data.mock

object PurchaseDetailMockData {

    val products = listOf(
        MockProductDetailData(
            id = 0,
            category = "Training Crew Socks",
            name = "Nike Everyday Plus Cushioned",
            price = 10,
            productImage = "https://www.figma.com/api/mcp/asset/9f3666c4-4f9f-4f61-928d-f4eabe9758dd",
            content = "The Nike Everyday Plus Cushioned Socks bring comfort to your workout with extra cushioning under the heel and forefoot and a snug, supportive arch band. Sweat-wicking power and breathability up top help keep your feet dry and cool to help push you through that extra set.",
            shown = "Multi-Color",
            styleNumber = "SX6897-965"
        ),
        MockProductDetailData(
            id = 1,
            category = "Basketball Socks",
            name = "Nike Elite Crew",
            price = 16,
            productImage = "https://i.imgur.com/m3PLPzh.png",
            content = "Nike Elite Crew socks are built for court feel and everyday comfort, with supportive cushioning and breathable fabric through the calf and foot.",
            shown = "White/Black",
            styleNumber = "DX5075-100"
        ),
        MockProductDetailData(
            id = 2,
            category = "Women's Shoes",
            name = "Nike Air Force 1 '07",
            price = 115,
            productImage = "https://i.imgur.com/5I8jISn.png",
            content = "The radiance lives on in the Nike Air Force 1 '07, with durable leather, classic construction and the same court-inspired look that made it a legend.",
            shown = "White",
            styleNumber = "DD8959-100"
        ),
        MockProductDetailData(
            id = 3,
            category = "Men's Shoes",
            name = "Jordan Essentials",
            price = 115,
            productImage = null,
            content = "Jordan Essentials pairs iconic Jordan DNA with everyday wearability for a clean look and dependable comfort.",
            shown = "Black/White",
            styleNumber = "FB7306-010"
        )
    )
}
