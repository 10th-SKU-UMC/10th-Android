package com.example.and_practice.presentation.ui.wish

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.and_practice.R
import com.example.and_practice.data.mock.MockProductData
import com.example.and_practice.data.mock.PurchaseMockData
import com.example.and_practice.presentation.ui.purchase.FavoriteViewModel
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
fun WishRoute(
    wishViewModel: WishViewModel = hiltViewModel(),
    favoriteViewModel: FavoriteViewModel,
    onProductClick: (Int) -> Unit = {}
) {
    val uiState by wishViewModel.uiState.collectAsState()
    val likedProductIds by favoriteViewModel.likedProductIds.collectAsState()

    val wishProducts = PurchaseMockData.products.filter { it.id in likedProductIds }

    WishScreen(
        products = wishProducts,
        likedProductIds = likedProductIds,
        onLikeClick = favoriteViewModel::toggleLike,
        onProductClick = onProductClick
    )
}

@Composable
fun WishScreen(
    products: List<MockProductData>,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit = {}
) {
    val typography = AndPracticeThemeTokens.typography

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "위시리스트",
            style = typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        // 리스트 비어있으면 처리
        if (products.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "위시리스트가 비어있습니다",
                    style = typography.itemSubtitle
                )
            }
        } else {
            WishProductGrid(
                products = products,
                likedProductIds = likedProductIds,
                onLikeClick = onLikeClick,
                onProductClick = onProductClick
            )
        }
    }
}

@Composable
private fun WishProductGrid(
    products: List<MockProductData>,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(
            items = products,
            key = { it.id }
        ) { product ->
            WishProductItem(
                product = product,
                isLiked = product.id in likedProductIds,
                onLikeClick = { onLikeClick(product.id) },
                onProductClick = { onProductClick(product.id) }
            )
        }
    }
}

@Composable
private fun WishProductItem(
    product: MockProductData,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    onProductClick: () -> Unit
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography

    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onProductClick() },
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box {
            AsyncImage(
                model = product.productImage,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = onLikeClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(34.dp)
                    .background(
                        color = colors.primaryWhite,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isLiked) R.drawable.ic_favorite_fill else R.drawable.ic_favorite_border
                    ),
                    contentDescription = "좋아요",
                    tint = Color.Unspecified
                )
            }
        }

        Text(text = product.name, style = typography.itemTitle)
        product.subName?.let {
            Text(
                text = it,
                style = typography.itemSubtitle.copy(color = colors.gray600)
            )
        }
        Text(text = "US$${product.price}", style = typography.priceLabel)
    }
}
