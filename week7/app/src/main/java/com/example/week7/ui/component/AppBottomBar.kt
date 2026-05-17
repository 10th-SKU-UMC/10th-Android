package com.example.week7.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.week7.navigation.BottomTab

@Composable
fun AppBottomBar(
    selected: BottomTab,
    onTabSelected: (BottomTab) -> Unit,//onTabSelected를 외부에서 받아와서 사용하겠다.
    ) {
        Row(
            modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()) {
            BottomTab.entries.forEach { tab ->
                val tint = if (tab == selected) Color.Black else Color.Gray
                Column(
                    modifier = Modifier.weight(1f)
                    .clickable { onTabSelected(tab) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(painterResource(tab.iconRes), tab.label, tint = tint)
                    Text(tab.label, color = tint, fontSize = 11.sp)
                }
            }
        }
    }
