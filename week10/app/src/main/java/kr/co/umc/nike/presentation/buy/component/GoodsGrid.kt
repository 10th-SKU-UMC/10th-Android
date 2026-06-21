package kr.co.umc.nike.presentation.buy.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun GoodsGrid(
    goods: List<Good>,
    modifier: Modifier = Modifier,
    onHeartClicked: (Int) -> Unit
) {
    // 가로 세로 모드 대응
//    val configuration = LocalConfiguration.current
//
//    val columns = when (configuration.orientation) {
//        Configuration.ORIENTATION_LANDSCAPE -> 4
//        else -> 2
//    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 12.dp
        ),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = goods,
            key = { good -> good.id }
        ) { good ->
            GoodCard(
                good = good,
                onHeartClicked = onHeartClicked,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoodsGridPreview() {
    NikeTheme {
        GoodsGrid(
            goods = listOf(
                Good(
                    id = 1,
                    goodImage = R.drawable.img_air_force,
                    isWished = false,
                    isBestSeller = true,
                    goodName = "Nike Air Force 1 '07",
                    goodDescription = "Men's Shoes",
                    colorDescription = "3 Colours",
                    goodPrice = "US$115"
                ),
                Good(
                    id = 2,
                    goodImage = R.drawable.img_air_force,
                    isWished = true,
                    isBestSeller = false,
                    goodName = "Nike Air Max 90",
                    goodDescription = "Women's Shoes",
                    colorDescription = "2 Colours",
                    goodPrice = "US$130"
                ),
                Good(
                    id = 3,
                    goodImage = R.drawable.img_air_force,
                    isWished = false,
                    isBestSeller = false,
                    goodName = "Nike Dunk Low",
                    goodDescription = "Men's Shoes",
                    colorDescription = "1 Colour",
                    goodPrice = "US$110"
                )
            ),
            onHeartClicked = {}
        )
    }
}
