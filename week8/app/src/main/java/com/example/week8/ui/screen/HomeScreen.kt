package com.example.week8.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.R
import com.example.week8.model.sampleProducts
import com.example.week8.ui.component.ProductHomeItem

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        item {
            Text(
                text = "Discovery",
                color = Color.Black,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold
            )
        }
        item { Spacer(modifier = Modifier.height(25.dp)) } //25dp의 빈 공간 만들어줌

        item {
            Text(
                text = "9월 4일 목요일",
                color = Color.Gray,
                fontSize = 40.sp
            )
        }
        item { Spacer(modifier = Modifier.height(40.dp)) }

        item {
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "기본사진",
                modifier = Modifier.size(380.dp)
            )
        }
        item { Spacer(modifier = Modifier.height(40.dp)) }

        item {
            Column {
                Text(text = "What's new", color = Color.Gray, fontSize = 14.sp)
                Text(
                    text = "나이키 최신 상품",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = sampleProducts,
                    key = { product -> product.id }
                ) { product ->
                    ProductHomeItem(product = product)
                }
            }
        }
    }
}