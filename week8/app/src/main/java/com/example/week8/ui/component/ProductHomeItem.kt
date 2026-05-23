package com.example.week8.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.model.Product

@Composable
fun ProductHomeItem(
    product: Product,
    modifier: Modifier= Modifier
){
    Column(modifier=modifier.width(200.dp)) {
        Image(
            painter = painterResource(id = product.imgRes),
            contentDescription = product.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF5F5F5))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = product.title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = product.price, fontSize = 13.sp, color = Color.DarkGray)
    }
}