package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .padding(horizontal = 4.dp)
            .background(Color.LightGray)
    )
}

@Preview(showBackground = true)
@Composable
private fun HorizontalDividerPreview() {
    NikeTheme {
        HorizontalDivider()
    }
}
