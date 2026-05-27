package com.example.and_practice.presentation.ui.mypage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun SectionDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(AndPracticeThemeTokens.colorScheme.gray100)
    )
}
