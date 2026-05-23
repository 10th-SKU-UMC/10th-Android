package com.wontwothree.week07.ui.screens.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wontwothree.week07.model.sampleProduct
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.tooling.preview.Preview
import com.wontwothree.week07.ui.components.ProductCard
import com.wontwothree.week07.ui.screens.whishlist.WhishlistScreen
import com.wontwothree.week07.ui.theme.Week07Theme

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
            items(sampleProduct,key = {product ->product.id}) { product ->
                if (!product.isNewArrival) ProductCard(product = product,isWishlisted = product.isWishList)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    Week07Theme(){
        ShopScreen()
    }
}
