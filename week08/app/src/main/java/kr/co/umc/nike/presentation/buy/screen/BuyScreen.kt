package kr.co.umc.nike.presentation.buy.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.buy.component.GoodsGrid
import kr.co.umc.nike.presentation.buy.component.TopBar
import kr.co.umc.nike.presentation.buy.model.Good
import kr.co.umc.nike.presentation.buy.viewmodel.GoodsViewModel
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.presentation.util.consume
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun BuyScreen(
    viewModel: GoodsViewModel = hiltViewModel()
) {
    val goodsState by viewModel.goodsState.collectAsStateWithLifecycle()

    BuyScreenContent(
        goodsState = goodsState,
        onHeartClicked = { id -> viewModel.toggleWish(id) }
    )
}

@Composable
fun BuyScreenContent(
    goodsState: UiState<List<Good>>,
    onHeartClicked: (Int) -> Unit
) {
    val tabs = listOf("전체", "Tops&T-Shirts", "sale")

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(16.dp))

        TopBar(
            currentTabIndex = pagerState.currentPage,
            tabs = tabs,
            onTabSelected = { index ->
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            }
        )

        goodsState.consume {

            loading {
                // TODO: 로딩 UI
            }

            success { goods ->
                HorizontalPager(
                    state = pagerState,
                ) { page ->
                    when (page) {
                        0 -> GoodsGrid(
                            goods = goods,
                            modifier = Modifier.fillMaxSize(),
                            onHeartClicked = onHeartClicked
                        )

                        1 -> Box(modifier = Modifier.fillMaxSize())

                        2 -> Box(modifier = Modifier.fillMaxSize())
                    }
                }
            }

            error { message ->
                // TODO: 에러 UI
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BuyScreenPreview() {
    NikeTheme {
        BuyScreenContent(
            goodsState = UiState.Success(
                listOf(
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
                )
            ),
            onHeartClicked = {}
        )
    }
}
