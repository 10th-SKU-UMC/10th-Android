package com.example.and_practice.presentation.ui.purchase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.and_practice.R
import com.example.and_practice.data.mock.MockProductData
import com.example.and_practice.data.mock.PurchaseMockData
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

/**
 * Screen과 뷰모델 연결
 */
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
    uiState: PurchaseUiState,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit = {}
) {
    val typography = AndPracticeThemeTokens.typography
    var selectedTab by remember { mutableStateOf("전체") }

    Column {
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        PurchaseTab(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it },
            tabTextStyle = typography.sectionEyebrow
        )

        ProductGrid(
            products = PurchaseMockData.products,
            likedProductIds = likedProductIds,
            onLikeClick = onLikeClick,
            onProductClick = onProductClick
        )
    }
}

/**
 * 상단 탭 바
 */
@Composable
private fun PurchaseTab(
    selectedTab: String,
    onTabClick: (String) -> Unit,
    tabTextStyle: androidx.compose.ui.text.TextStyle
) {
    Row(modifier = Modifier.padding(start = 9.dp)) {
        PurchaseUnderlineTab(
            text = "전체",
            selected = selectedTab == "전체",
            onClick = { onTabClick("전체") },
            tabTextStyle = tabTextStyle
        )
        PurchaseUnderlineTab(
            text = "Tops & T-Shirts",
            selected = selectedTab == "Tops & T-Shirts",
            onClick = { onTabClick("Tops & T-Shirts") },
            tabTextStyle = tabTextStyle
        )
        PurchaseUnderlineTab(
            text = "sale",
            selected = selectedTab == "sale",
            onClick = { onTabClick("sale") },
            tabTextStyle = tabTextStyle
        )
    }
}

/**
 * 개별 탭
 */
@Composable
private fun PurchaseUnderlineTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    tabTextStyle: androidx.compose.ui.text.TextStyle,
    modifier: Modifier = Modifier
) {
    val colors = AndPracticeThemeTokens.colorScheme
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = tabTextStyle.copy(
                color = if (selected) colors.primaryBlack else colors.gray600
            ),
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(
                    if (selected) colors.primaryBlack else Color.Transparent
                )
        )
    }
}

/**
 * 상품 리스트
 */
@Composable
private fun ProductGrid(
    products: List<MockProductData>,
    likedProductIds: Set<Int>,
    onLikeClick: (Int) -> Unit,
    onProductClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(41.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = products,
            key = { it.id }
        ) { product ->
            ProductItem(
                product = product,
                isLiked = product.id in likedProductIds,
                onLikeClick = { onLikeClick(product.id) },
                onProductClick = { onProductClick(product.id) }
            )
        }
    }
}

/**
 * 상품 아이템
 */
@Composable
private fun ProductItem(
    product: MockProductData,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    onProductClick: () -> Unit
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
        modifier = Modifier.clickable { onProductClick() },
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .background(colors.gray300)
        ) {
            AsyncImage(
                model = product.productImage,
                contentDescription = product.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = onLikeClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 12.dp, end = 12.dp)
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

        Column(
            modifier = Modifier.padding(horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            product.badge?.let {
                Text(
                    text = "BestSeller",
                    style = typography.itemSubtitle.copy(color = colors.warning500)
                )
            }
            Text(
                text = product.name,
                style = typography.itemTitle
            )
            product.subName?.let {
                Text(
                    text = it,
                    style = typography.itemSubtitle.copy(color = colors.gray600)
                )
            }
            product.colorCount?.let {
                Text(
                    text = "$it Colours",
                    style = typography.itemSubtitle.copy(color = colors.gray600)
                )
            }
            Text(
                text = "US$${product.price}",
                style = typography.priceLabel
            )
        }
    }
}
