package com.example.week8.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.model.sampleProducts
import com.example.week8.ui.component.ProductItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

@Composable
fun BuyScreen (
    wishlistedIds: List<Int>,
    onToggleWishlist: (Int) -> Unit = {},
    onProductClick: (Int) -> Unit ={}
){
    val tabs=listOf("전체", "Tops & T-Shirts", "sale")
    var selectedTab by remember { mutableStateOf(0)}

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical=12.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            tabs.forEachIndexed { index, title ->
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal,
                    color = if (selectedTab == index) Color.Black else Color.Gray,
                    modifier = Modifier.clickable { selectedTab = index }
                )
            }
        }
        val filtered = when (selectedTab) {
            1 -> sampleProducts.filter { it.category == "Tops & T-Shirts" }
            2 -> sampleProducts.filter { it.isBestSeller }
            else -> sampleProducts
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = filtered,
                key = { product -> product.id }
            ) { product ->
                ProductItem(
                    product = product,
                    isWishlisted = wishlistedIds.contains(product.id),
                    onToggleWishlist = { onToggleWishlist(product.id) },
                    onClick = { onProductClick(product.id) }
                )
            }
        }
    }
}