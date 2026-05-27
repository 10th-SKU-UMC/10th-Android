package com.example.and_practice.presentation.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.data.mock.MockRecentItemData

@Composable
internal fun RecentProductItem(
    item: MockRecentItemData,
    onProductClick: () -> Unit = {}
) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column {
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
