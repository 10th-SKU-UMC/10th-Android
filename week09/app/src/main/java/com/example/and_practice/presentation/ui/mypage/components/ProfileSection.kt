package com.example.and_practice.presentation.ui.mypage.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun ProfileSection(
    nickname: String,
    profileImageUrl: String,
    onEditClick: () -> Unit
) {
    val colors = AndPracticeThemeTokens.colorScheme

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        AsyncImage(
            model = profileImageUrl,
            contentDescription = "프로필 이미지",
            modifier = Modifier
                .size(84.dp)
                .clip(CircleShape)
                .background(colors.gray300),
            contentScale = ContentScale.Crop
        )

        Text(text = nickname, fontSize = 20.sp, fontWeight = FontWeight.Medium)

        OutlinedButton(
            onClick = onEditClick,
            border = BorderStroke(1.dp, colors.gray200),
            shape = RoundedCornerShape(100.dp),
            contentPadding = PaddingValues(horizontal = 51.dp, vertical = 16.dp)
        ) {
            Text(text = "프로필 수정", color = colors.gray700, fontSize = 16.sp)
        }
    }
}
