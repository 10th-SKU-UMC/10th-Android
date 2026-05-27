package com.example.and_practice.presentation.ui.purchase

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.and_practice.R
import com.example.and_practice.data.mock.MockProductDetailData
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
fun PurchaseDetailRoute(
    productId: Int,
    onBack: () -> Unit = {},
    viewModel: PurchaseDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

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

/**
 * 상세보기 헤더 탭
 */
@Composable
private fun ProductControlBar(
    product: MockProductDetailData,
    onBack: () -> Unit
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 15.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(0.18f),
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "뒤로가기",
                tint = colors.primaryBlack,
                modifier = Modifier.clickable { onBack() }
            )
        }

        Text(
            text = product.name,
            modifier = Modifier.weight(1f),
            style = typography.sectionEyebrow.copy(
                color = colors.primaryBlack
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "검색",
                tint = colors.primaryBlack
            )
        }
    }
}

@Composable
private fun ProductImageSection(
    product: MockProductDetailData
) {
    val colors = AndPracticeThemeTokens.colorScheme
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp, vertical = 12.dp)
            .background(
                color = colors.gray300,
                shape = RoundedCornerShape(0.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = product.productImage,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(366.dp),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 63.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(
                            color = colors.gray300,
                            shape = RoundedCornerShape(3.dp)
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.31f)
                        .height(2.dp)
                        .align(Alignment.CenterStart)
                        .background(
                            color = colors.gray700,
                            shape = RoundedCornerShape(3.dp)
                        )
                )
            }
        }
    }
}

@Composable
private fun ProductContentSection(
    product: MockProductDetailData
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = product.category,
                    style = typography.sectionEyebrow.copy(
                        color = colors.primaryBlack
                    )
                )
                Text(
                    text = product.name,
                    style = typography.headlineLarge.copy(
                        color = colors.primaryBlack
                    )
                )
            }

            Text(
                text = "US$${product.price}",
                style = typography.sectionEyebrow.copy(
                    color = colors.primaryBlack
                )
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Text(
                text = product.content,
                style = typography.bodyLarge.copy(
                    color = colors.primaryBlack
                )
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "•  Shown: ${product.shown}",
                    style = typography.bodyLarge.copy(
                        color = colors.primaryBlack
                    )
                )
                Text(
                    text = "•  Style: ${product.styleNumber}",
                    style = typography.bodyLarge.copy(
                        color = colors.primaryBlack
                    )
                )
            }

            Text(
                text = "View Product Details",
                style = typography.bodyLarge.copy(
                    color = colors.gray600
                )
            )
        }
    }
}

@Composable
private fun ProductActionSection() {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
        modifier = Modifier.padding(horizontal = 43.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(1.dp, colors.gray200),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colors.primaryBlack
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "사이즈 선택",
                    style = typography.sectionEyebrow.copy(
                        color = colors.primaryBlack
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "사이즈 선택 펼치기 icon",
                    tint = colors.primaryBlack
                )
            }
        }

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.primaryBlack,
                contentColor = colors.primaryWhite
            )
        ) {
            Text(
                text = "장바구니에 추가",
                style = typography.sectionEyebrow.copy(
                    color = colors.primaryWhite
                )
            )
        }
        // 위시리스트 버튼
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(1.dp, colors.gray200),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = colors.primaryBlack
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "위시리스트",
                    style = typography.sectionEyebrow.copy(
                        color = colors.primaryBlack
                    )
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_heartstraight),
                    contentDescription = "위시리스트"
                )
            }
        }
    }
}
