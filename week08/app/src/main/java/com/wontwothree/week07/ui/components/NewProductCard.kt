package com.wontwothree.week07.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wontwothree.week07.model.Product
import com.wontwothree.week07.model.sampleProduct

@Composable
fun NewProductCard(product: Product){
    Column() {
        Image(
            painter = painterResource(id= product.imageRes),
            contentDescription = "신상품 이미지",
            modifier = Modifier
                .height(314.dp)
                .width(314.dp),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(20.dp))
        Text(
            product.name,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(16.dp))
        Text(
            "US$${product.price}",
            color = Color(0xFF767676)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NewProductCardPreview(){
    NewProductCard(sampleProduct[0])
}
