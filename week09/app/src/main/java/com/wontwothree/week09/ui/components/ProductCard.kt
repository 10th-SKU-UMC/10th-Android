package com.wacaw.week09.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wacaw.week09.R
import com.wacaw.week09.model.Product

@Composable
fun ProductCard(
    product: Product,
    isWishlisted: Boolean,) {

    var isWishlisted by remember { mutableStateOf(product.isWishList) }

    Column(
        modifier = Modifier
            .width(184.dp)
    ) {

        Box() {
            Image(
                painter = painterResource(id= product.imageRes),
                contentDescription = "상품 이미지",
                modifier = Modifier
                    .height(184.dp)
                    .width(184.dp),
                contentScale = ContentScale.FillWidth
            )
            IconButton(
                onClick = { isWishlisted = !isWishlisted },
                modifier = Modifier.align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id=
                        if (isWishlisted) R.drawable.ic_heart_filled
                        else R.drawable.ic_heart),
                    contentDescription = "위시리스트",
                )
            }
        }


        Spacer(Modifier.height(14.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 14.dp)
        ) {
            if(product.isBestSeller){
                Text(
                    "BestSeller",
                    fontSize = 14.sp,
                    color = Color(0xFFFC5100)
                )
                Spacer(Modifier.height(5.dp))
            }
            Text(
                product.name,
                fontSize = 14.sp
            )
            Spacer(Modifier.height(5.dp))
            Text(
                product.category,
                fontSize = 14.sp,
                color = Color(0xFF767676)
            )
            Spacer(Modifier.height(5.dp))
            Text(
                "${product.colors} Colours",
                fontSize = 14.sp,
                color = Color(0xFF767676)
            )
            Spacer(Modifier.height(5.dp))
            Text(
                "US$${product.price}",
                fontSize = 14.sp
            )
        }

    }

}

//@Preview(showBackground = true)
//@Composable
//fun ProductCardPreview(){
//    ProductCard(sampleProduct[2])
//}
