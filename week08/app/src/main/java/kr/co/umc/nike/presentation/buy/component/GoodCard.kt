package kr.co.umc.nike.presentation.buy.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.GoodInfo
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun GoodCard(
    good: Good,
    onHeartClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {
            Image(
                painter = painterResource(good.goodImage),
                contentDescription = "상품 사진",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            HeartCircle(
                isLiked = good.isWished,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .size(34.dp)
                    .clickable(
                        // 리플효과 제거
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        onHeartClicked(good.id)
                    }
            )
        }

        Spacer(Modifier.height(10.dp))

        GoodInfo(
            name = good.goodName,
            description = good.goodDescription,
            colorNum = good.colorDescription,
            price = good.goodPrice,
            isBestSeller = good.isBestSeller
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GoodCardPreview() {
    NikeTheme {
        GoodCard(
            good = Good(
                id = 1,
                goodImage = R.drawable.img_air_force,
                isWished = false,
                isBestSeller = true,
                goodName = "Nike Air Force 1 '07",
                goodDescription = "Men's Shoes",
                colorDescription = "3 Colours",
                goodPrice = "US$115"
            ),
            onHeartClicked = {}
        )
    }
}

