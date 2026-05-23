package com.example.week8.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8.model.sampleProducts
import com.example.week8.ui.component.ProductItem

@Composable
fun WishlistScreen(
    wishlistedIds: List<Int>,
    onToggleWishlist: (Int) -> Unit = {},
    onProductClick: (Int) -> Unit = {}
) {
    val wishlist = sampleProducts.filter { wishlistedIds.contains(it.id) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "위시리스트",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = wishlist,
                key = { product -> product.id }
            ) { product ->
                ProductItem(
                    product = product,
                    isWishlisted = true,
                    onToggleWishlist={onToggleWishlist(product.id)},
                    onClick = { onProductClick(product.id) }
                )
            }
        }
    }
}