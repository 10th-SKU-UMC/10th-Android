package com.wontwothree.week07.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.wontwothree.week07.ui.theme.Week07Theme

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp, vertical = 50.dp)
    ) {
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

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        HomeScreen()
    }
}
