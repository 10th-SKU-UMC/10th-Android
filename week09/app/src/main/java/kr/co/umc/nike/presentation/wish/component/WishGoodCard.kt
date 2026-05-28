package kr.co.umc.nike.presentation.wish.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.GoodInfo
import kr.co.umc.nike.presentation.wish.model.WishGood
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun WishGoodCard(
    good: WishGood
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.width(184.dp)
    ) {
        Image(
            painter = painterResource(good.goodImage),
            contentDescription = "위시 상품",
            modifier = Modifier.size(184.dp)
        )

        Spacer(Modifier.height(10.dp))

        GoodInfo(
            name = good.goodName,
            description = good.description,
            colorNum = good.colorDescription,
            price = good.goodPrice,
            modifier = Modifier
                .padding(horizontal = 14.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun WishGoodCardPreview() {
    NikeTheme {
        WishGoodCard(
            good = WishGood(
                id = 1,
                goodImage = R.drawable.img_air_force,
                goodName = "Nike Everyday Plus Cushioned",
                description = "Training Ankle Socks (6 Pairs)",
                colorDescription = "5 Colours",
                goodPrice = "US\$10"
            )
        )
    }
}