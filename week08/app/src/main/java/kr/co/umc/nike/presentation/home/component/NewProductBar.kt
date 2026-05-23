package kr.co.umc.nike.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun NewProductBar(
    eng: String,
    kor: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = eng,
            color = Color.Black,
            fontSize = 16.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )
        Text(
            text = kor,
            color = CustomGray,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewProductBarPreview() {
    NikeTheme {
        NewProductBar(
            eng = "What’s new",
            kor = "나이키 최신 상품"
        )
    }
}