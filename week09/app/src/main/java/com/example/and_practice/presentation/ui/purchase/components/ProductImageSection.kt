package com.example.and_practice.presentation.ui.purchase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.data.mock.MockProductDetailData

@Composable
internal fun ProductImageSection(product: MockProductDetailData) {
    val colors = AndPracticeThemeTokens.colorScheme
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 19.dp, vertical = 12.dp)
            .background(color = colors.gray300, shape = RoundedCornerShape(0.dp))
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
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
                        .background(color = colors.gray300, shape = RoundedCornerShape(3.dp))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.31f)
                        .height(2.dp)
                        .align(Alignment.CenterStart)
                        .background(color = colors.gray700, shape = RoundedCornerShape(3.dp))
                )
            }
        }
    }
}
