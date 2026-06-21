package kr.co.umc.nike.presentation.bag.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.R
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun NonePlaceHolder(
    iconRes: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = "가방 아이콘"
        )

        Spacer(
            modifier = Modifier.height(27.dp)
        )

        Text(
            text = text,
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            lineHeight = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NonePlaceHolderPreview() {
    NikeTheme {
        NonePlaceHolder(
            iconRes = R.drawable.bag_circle,
            text = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다."
        )
    }
}