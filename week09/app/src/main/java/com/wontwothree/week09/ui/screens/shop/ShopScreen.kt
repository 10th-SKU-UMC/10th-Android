package com.wacaw.week09.ui.screens.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wacaw.week09.model.sampleProduct
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.tooling.preview.Preview
import com.wacaw.week09.ui.components.ProductCard
import com.wacaw.week09.ui.theme.Week09Theme

@Composable
fun ShopScreen() {

    Column(
    ){
        Spacer(Modifier.height(50.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(
                items = sampleProduct,
                key = { it.id }
            ) {
                if (!it.isNewArrival) {
                    ProductCard(
                        product = it,
                        isWishlisted = it.isWishList
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    Week09Theme(){
        ShopScreen()
    }
}
