package com.example.and_practice.presentation.ui.purchase.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun PurchaseTab(
    selectedTab: String,
    onTabClick: (String) -> Unit,
    tabTextStyle: TextStyle
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

@Composable
private fun PurchaseUnderlineTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    tabTextStyle: TextStyle,
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
                .background(if (selected) colors.primaryBlack else Color.Transparent)
        )
    }
}
