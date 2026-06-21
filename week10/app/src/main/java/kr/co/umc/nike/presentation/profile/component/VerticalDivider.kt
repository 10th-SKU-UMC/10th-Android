package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(1.dp)
            .height(32.dp)
            .background(Color.LightGray)
    )
}

@Preview(showBackground = true)
@Composable
private fun VerticalDividerPreview() {
    NikeTheme {
        VerticalDivider()
    }
}