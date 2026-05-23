package com.example.week8.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.model.Product
import androidx.compose.foundation.clickable

@Composable
fun ProductItem(
    product: Product,
    isWishlisted: Boolean,
    onToggleWishlist: () -> Unit = {},
    onClick: () -> Unit = {},
    modifier: Modifier=Modifier
) {
    Column(modifier = modifier.clickable{ onClick()}) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF5F5F4))
        ) {
            Image(
                painter = painterResource(id = product.imgRes),
                contentDescription = product.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { onToggleWishlist() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isWishlisted) Icons.Filled.Favorite
                                  else Icons.Outlined.FavoriteBorder,
                    contentDescription = "wishlist",
                    tint = if (isWishlisted) Color.Red else Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        Spacer(modifier=Modifier.height(8.dp))

        if (product.isBestSeller){
            Text(
                text="BestSeller",
                color=Color(0xFFFF6B00),
                fontWeight= FontWeight.Bold,
                fontSize=12.sp
            )
        }
        Text(
            text=product.title,
            fontWeight=FontWeight.Bold,
            fontSize=14.sp
        )

        product.description?.let {
            Text(
                text = it,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
        Text(
            text=product.price,
            fontWeight=FontWeight.SemiBold,
            fontSize=14.sp,
            modifier=Modifier.padding(top=4.dp)
        )
    }
}