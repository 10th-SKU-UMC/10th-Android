package com.example.and_practice.presentation.ui.purchase

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.core.ui.LoadingScreen
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.presentation.ui.purchase.components.ProductGrid
import com.example.and_practice.presentation.ui.purchase.components.PurchaseTab

@Composable
fun PurchaseRoute(
    viewModel: PurchaseViewModel = hiltViewModel(),
    favoriteViewModel: FavoriteViewModel,
    onProductClick: (Int) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    val likedProductIds by favoriteViewModel.likedProductIds.collectAsState()
    PurchaseScreen(
        uiState = uiState,
        likedProductIds = likedProductIds,
        onLikeClick = favoriteViewModel::toggleLike,
        onProductClick = onProductClick
    )
}

@Composable
fun PurchaseScreen(
    uiState: UiState<PurchaseData>,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit = {}
) {
    when (uiState) {
        is UiState.Loading -> LoadingScreen()
        is UiState.Error -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = uiState.error.defaultMessage)
        }
        is UiState.Success -> {
            val typography = AndPracticeThemeTokens.typography
            var selectedTab by remember { mutableStateOf("전체") }

            Column {
                Spacer(modifier = Modifier.height(15.dp))
                PurchaseTab(
                    selectedTab = selectedTab,
                    onTabClick = { selectedTab = it },
                    tabTextStyle = typography.sectionEyebrow
                )
                ProductGrid(
                    products = uiState.data.products,
                    likedProductIds = likedProductIds,
                    onLikeClick = onLikeClick,
                    onProductClick = onProductClick
                )
            }
        }
    }
}
