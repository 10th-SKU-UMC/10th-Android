package com.example.and_practice.presentation.ui.mypage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun JoinDateSection(joinDate: String = "2025년 9월") {
    val colors = AndPracticeThemeTokens.colorScheme

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colors.gray100)
            .padding(vertical = 19.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "회원 가입일: $joinDate", fontSize = 12.sp, color = colors.gray600)
    }
}
