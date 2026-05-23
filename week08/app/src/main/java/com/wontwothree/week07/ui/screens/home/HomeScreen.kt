package com.wontwothree.week07.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wontwothree.week07.R
import com.wontwothree.week07.model.sampleProduct
import com.wontwothree.week07.ui.components.NewProductCard
import com.wontwothree.week07.ui.theme.Week07Theme

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(50.dp))
        Column(
            modifier = Modifier
                .padding(horizontal = 17.dp)
        ){
            Text(
                "Discover",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "9월 4일 목요일",
                color = Color(0xFF767676)
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
        Image(
            painter = painterResource(id= R.drawable.img_home_main),
            contentDescription = "홈 메인 이미지",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(Modifier.height(40.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 17.dp)
        ){
            Text("What's new",
                fontSize = 16.sp)
            Text("나이키 최신 상품", fontSize = 28.sp)
            Spacer(Modifier.height(20.dp))
            LazyRow() {
                items(sampleProduct, key = {product ->product.id}) { product ->
                    if (product.isNewArrival) NewProductCard(product)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        HomeScreen()
    }
}
