package com.example.and_practice.presentation.ui.mypage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens
import com.example.and_practice.data.remote.dto.FollowingPreviewDTO

@Composable
internal fun FollowingSection(followings: List<FollowingPreviewDTO>) {
    val colors = AndPracticeThemeTokens.colorScheme

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 28.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "팔로잉 (${followings.size})", fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(
                text = "편집",
                fontSize = 12.sp,
                color = colors.gray600,
                modifier = Modifier.clickable { }
            )
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            items(followings) { following ->
                AsyncImage(
                    model = following.profileImageUrl,
                    contentDescription = following.nickname,
                    modifier = Modifier
                        .size(107.dp)
                        .background(colors.gray300),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
