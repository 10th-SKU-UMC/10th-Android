package com.example.week7.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week7.R

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Text(
            text="Discovery",
            color= Color.Black,
            fontSize=80.sp,
            fontWeight= FontWeight.Bold
        )

        Spacer(modifier= Modifier.height(25.dp)) //40dp의 빈 공간 만들어줌

        Text(
            text="9월 4일 목요일",
            color= Color.Gray,
            fontSize=40.sp
        )

        Spacer(modifier= Modifier.height(40.dp))

        Image(
            painter= painterResource(id= R.drawable.photo),
            contentDescription="기본사진",
            modifier = Modifier.size(800.dp)
        )}

}