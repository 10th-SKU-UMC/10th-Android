package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun FollowingBar(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "팔로잉 (3)",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "편집",
            fontSize = 12.sp,
            color = CustomGray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FollowingBarPreview() {
    NikeTheme {
        FollowingBar(
            text1 = "팔로잉 (3)",
            text2 = "편집"
        )
    }
}