package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun BottomBar(
    text: String,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            color = CustomGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    NikeTheme {
        BottomBar(text = "회원 가입일: 2025년 9월")
    }
}