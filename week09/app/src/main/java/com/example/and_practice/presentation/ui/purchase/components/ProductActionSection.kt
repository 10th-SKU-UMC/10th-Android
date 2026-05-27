package com.example.and_practice.presentation.ui.purchase.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.and_practice.R
import com.example.and_practice.core.designsystem.AndPracticeThemeTokens

@Composable
internal fun ProductActionSection() {
    val colors = AndPracticeThemeTokens.colorScheme
    val typography = AndPracticeThemeTokens.typography
    Column(
        modifier = Modifier.padding(horizontal = 43.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(1.dp, colors.gray200),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.primaryBlack)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "사이즈 선택",
                    style = typography.sectionEyebrow.copy(color = colors.primaryBlack)
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "사이즈 선택 펼치기 icon",
                    tint = colors.primaryBlack
                )
            }
        }

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colors.primaryBlack,
                contentColor = colors.primaryWhite
            )
        ) {
            Text(
                text = "장바구니에 추가",
                style = typography.sectionEyebrow.copy(color = colors.primaryWhite)
            )
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(100.dp),
            border = BorderStroke(1.dp, colors.gray200),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colors.primaryBlack)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "위시리스트",
                    style = typography.sectionEyebrow.copy(color = colors.primaryBlack)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_heartstraight),
                    contentDescription = "위시리스트"
                )
            }
        }
    }
}
