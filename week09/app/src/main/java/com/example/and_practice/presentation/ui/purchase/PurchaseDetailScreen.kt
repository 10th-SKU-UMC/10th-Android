package com.example.and_practice.presentation.ui.purchase

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.data.mock.MockProductDetailData
import com.example.and_practice.presentation.ui.purchase.components.ProductActionSection
import com.example.and_practice.presentation.ui.purchase.components.ProductContentSection
import com.example.and_practice.presentation.ui.purchase.components.ProductControlBar
import com.example.and_practice.presentation.ui.purchase.components.ProductImageSection

@Composable
fun PurchaseDetailRoute(
    productId: Int,
    onBack: () -> Unit = {},
    viewModel: PurchaseDetailViewModel = hiltViewModel()
) {
    val wrapper by viewModel.uiState.collectAsState()
    val uiState = (wrapper as? UiState.Success)?.data ?: PurchaseDetailUiState()

    LaunchedEffect(productId) {
        viewModel.loadProduct(productId)
    }

    uiState.product?.let { product ->
        PurchaseDetailScreen(
            product = product,
            onBack = onBack
        )
    }
}

@Composable
fun PurchaseDetailScreen(
    product: MockProductDetailData,
    onBack: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AndPracticeThemeTokens.colorScheme.primaryWhite)
            .windowInsetsPadding(WindowInsets.statusBars)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ProductControlBar(product = product, onBack = onBack)
        ProductImageSection(product = product)
        ProductContentSection(product = product)
        ProductActionSection()
    }
}

