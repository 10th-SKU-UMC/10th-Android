package com.wontwothree.week07.ui.screens.whishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wontwothree.week07.ui.screens.home.HomeScreen
import com.wontwothree.week07.ui.theme.Week07Theme

@Composable
fun WhishlistScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp, vertical = 50.dp)
    ) {
        Text("위시리스트",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        WhishlistScreen()
    }
}
