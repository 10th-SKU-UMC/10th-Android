package com.example.and_practice.presentation.ui.home

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.and_practice.R
import com.example.and_practice.data.mock.MockRecentItemData
import com.example.and_practice.core.designsystem.AndPracticeTheme
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onProductClick: (Int) -> Unit = {}
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    val context = LocalContext.current
    var backPressedTime by remember { mutableLongStateOf(0L) }

    BackHandler {
        val currentTime = System.currentTimeMillis()
        if (currentTime - backPressedTime < 2000) {
            (context as? Activity)?.finish()
        } else {
            backPressedTime = currentTime
            Toast.makeText(context, "한 번 더 누르면 종료됩니다", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.primaryWhite)
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 17.dp, vertical = 24.dp)
        ) {
            Text(
                text = uiState.title,
                style = typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = uiState.dateText,
                style = typography.sectionEyebrow
            )
        }

        Image(
            painter = painterResource(id = R.drawable.home_logo),
            contentDescription = "홈 이미지",
            modifier = Modifier
                .padding(horizontal = 17.dp)
                .fillMaxWidth()
                .height(500.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 17.dp)
                .padding(top = 40.dp, bottom = 12.dp)
        ) {
            Text(
                text = "What's new",
                style = typography.sectionTitle
            )
            Text(
                text = "나이키 최신 상품",
                style = typography.headlineLarge.copy(color = colors.gray600)
            )
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = uiState.recentItems,
                key = { it.id }
            ) { item ->
                RecentProductItem(
                    item = item,
                    onProductClick = { onProductClick(item.id) }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
private fun RecentProductItem(
    item: MockRecentItemData,
    onProductClick: () -> Unit = {}
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
    ) {
        Box(
            modifier = Modifier
                .size(314.dp)
                .background(Color(0xFFF5F5F5))
                .aspectRatio(1f)
                .clickable { onProductClick() }
        ) {
            AsyncImage(
                model = item.productImage,
                contentDescription = item.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = item.name,
            style = typography.itemTitle.copy(color = colors.primaryBlack),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        item.price?.let { price ->
            Text(
                text = price,
                style = typography.itemSubtitle.copy(color = colors.gray600)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_7")
@Composable
fun HomeScreenPreview() {
    AndPracticeTheme {
        HomeScreen(
            uiState = HomeUiState(
                title = "Discover",
                dateText = "05월 18일 월요일"
            )
        )
    }
}
