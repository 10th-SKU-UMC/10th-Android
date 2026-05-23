package com.wontwothree.week07.ui.screens.whishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wontwothree.week07.model.sampleProduct
import com.wontwothree.week07.ui.components.ProductCard
import com.wontwothree.week07.ui.theme.Week07Theme

@Composable
fun WhishlistScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(50.dp))
        Text("위시리스트",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(30.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(sampleProduct, key = {product ->product.id}) { product ->
                if (product.isWishList) ProductCard(product = product, isWishlisted = product.isWishList)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Week07Theme(){
        WhishlistScreen()
    }
}
