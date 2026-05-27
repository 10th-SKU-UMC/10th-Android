package com.example.and_practice.presentation.ui.wish

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.mock.PurchaseMockData
import com.example.and_practice.presentation.ui.purchase.FavoriteViewModel
import com.example.and_practice.presentation.ui.wish.components.WishProductGrid

@Composable
fun WishRoute(
    wishViewModel: WishViewModel = hiltViewModel(),
    favoriteViewModel: FavoriteViewModel,
    onProductClick: (Int) -> Unit = {}
) {
    val uiState by wishViewModel.uiState.collectAsState()
    val likedProductIds by favoriteViewModel.likedProductIds.collectAsState()

    // likedProductIds 변경될 때마다 위시 목록 갱신
    LaunchedEffect(likedProductIds) {
        wishViewModel.updateWishProducts(PurchaseMockData.products, likedProductIds)
    }

    WishScreen(
        uiState = uiState,
        likedProductIds = likedProductIds,
        onLikeClick = favoriteViewModel::toggleLike,
        onProductClick = onProductClick
    )
}

@Composable
fun WishScreen(
    uiState: UiState<WishData>,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit = {}
) {
    val typography = AndPracticeThemeTokens.typography

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "위시리스트",
            style = typography.headlineLarge,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )

        when (uiState) {
            is UiState.Loading -> Unit
            is UiState.Error -> Unit
            is UiState.Success -> {
                if (uiState.data.products.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(text = "위시리스트가 비어있습니다", style = typography.itemSubtitle)
                    }
                } else {
                    WishProductGrid(
                        products = uiState.data.products,
                        likedProductIds = likedProductIds,
                        onLikeClick = onLikeClick,
                        onProductClick = onProductClick
                    )
                }
            }
        }
    }
}
