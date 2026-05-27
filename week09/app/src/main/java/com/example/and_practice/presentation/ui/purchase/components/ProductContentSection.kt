package com.example.and_practice.presentation.ui.purchase.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.data.mock.MockProductDetailData

@Composable
internal fun ProductContentSection(product: MockProductDetailData) {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = product.category,
                    style = typography.sectionEyebrow.copy(color = colors.primaryBlack)
                )
                Text(
                    text = product.name,
                    style = typography.headlineLarge.copy(color = colors.primaryBlack)
                )
            }
            Text(
                text = "US$${product.price}",
                style = typography.sectionEyebrow.copy(color = colors.primaryBlack)
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
            Text(
                text = product.content,
                style = typography.bodyLarge.copy(color = colors.primaryBlack)
            )
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "•  Shown: ${product.shown}",
                    style = typography.bodyLarge.copy(color = colors.primaryBlack)
                )
                Text(
                    text = "•  Style: ${product.styleNumber}",
                    style = typography.bodyLarge.copy(color = colors.primaryBlack)
                )
            }
            Text(
                text = "View Product Details",
                style = typography.bodyLarge.copy(color = colors.gray600)
            )
        }
    }
}
