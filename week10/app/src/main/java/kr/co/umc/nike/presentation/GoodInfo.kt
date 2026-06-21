package kr.co.umc.nike.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.Black
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme
import kr.co.umc.nike.ui.theme.Orange500

@Composable
fun GoodInfo(
    name: String,
    description: String,
    colorNum: String,
    price: String,
    modifier: Modifier = Modifier,
    isBestSeller: Boolean = false,
    textSize: TextUnit = 14.sp,
) {

    // 멀티라인 텍스트 줄간격 및 불필요한 font padding 제거
    val baseTextStyle = TextStyle(
        platformStyle = PlatformTextStyle(includeFontPadding = false),
        lineHeight = textSize * 1.2
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (isBestSeller) {
            Text(
                text = "BestSeller",
                fontSize = textSize,
                color = Orange500,
                style = baseTextStyle,
                fontWeight = FontWeight.Medium
            )
        }

        Text(
            text = name,
            fontSize = textSize,
            color = Black,
            style = baseTextStyle,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = description,
            fontSize = textSize,
            color = CustomGray,
            style = baseTextStyle,
            lineHeight = (textSize.value * 1.2).sp,
        )

        Text(
            text = colorNum,
            fontSize = textSize,
            color = CustomGray,
            style = baseTextStyle,
        )

        Text(
            text = price,
            fontSize = textSize,
            color = Black,
            fontWeight = FontWeight.Medium,
            style = baseTextStyle,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GoodInfoPreview() {
    NikeTheme {
        GoodInfo(
            name = "Nike Everyday Plus Cushioned",
            description = "Training Ankle Socks (6 Pairs)",
            colorNum = "1 Color",
            price = "US$185",
            isBestSeller = true
        )
    }
}