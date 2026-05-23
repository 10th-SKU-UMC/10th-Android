package kr.co.umc.nike.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.home.model.NewGood
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun NewGoodCard(
    good: NewGood
) {
    Column {
        Image(
            painter = painterResource(good.goodImage),
            contentDescription = "새 상품",
            modifier = Modifier.size(314.dp)
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = good.goodName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        Text(
            text = good.goodPrice,
            color = Color.Gray,
            fontSize = 14.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NewGoodCardPreview() {
    NikeTheme {
        NewGoodCard(
            good = NewGood(
                id = 1,
                goodImage = R.drawable.img_air_force,
                goodName = "Air Jordan XXXVI",
                goodPrice = "US\$185"
            )
        )
    }
}
