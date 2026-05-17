package kr.co.umc.nike.presentation.buy.screen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.presentation.buy.component.TobBar

@Composable
fun BuyScreen()  {
    var selectedTabIndexState by remember { mutableIntStateOf(0) }
    val tabs = listOf("전체", "Tops&T-Shirts", "sale")

    Spacer(
        modifier = Modifier
            .height(16.dp)
    )

    TobBar(
        currentTabIndex = selectedTabIndexState,
        tabs = tabs,
        onTabSelected = { selectedTabIndexState = it }
    )
}

@Preview(showBackground = true)
@Composable
fun BuyScreenPreview() {
    BuyScreen()
}