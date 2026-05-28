package com.example.and_practice.presentation.ui.mypage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.and_practice.R
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun NavigateButtonRow() {
    val colors = AndPracticeThemeTokens.colorScheme
    val items = listOf(
        Pair(R.drawable.ic_archive, "주문"),
        Pair(R.drawable.ic_identificationcard, "패스"),
        Pair(R.drawable.ic_calendarblank, "이벤트"),
        Pair(R.drawable.ic_gear, "설정")
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, (iconRes, label) ->
            NavigateButton(iconRes = iconRes, label = label)

            if (index < items.lastIndex) {
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(31.dp)
                        .background(colors.gray300)
                )
            }
        }
    }
}

@Composable
private fun NavigateButton(iconRes: Int, label: String) {
    val colors = AndPracticeThemeTokens.colorScheme

    Column(
        modifier = Modifier
            .clickable { }
            .padding(horizontal = 28.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Icon(painter = painterResource(iconRes), contentDescription = label, tint = colors.gray600, modifier = Modifier.size(24.dp))
        Text(text = label, fontSize = 12.sp, color = colors.gray600)
    }
}
