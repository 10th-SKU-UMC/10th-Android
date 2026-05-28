package kr.co.umc.nike.presentation.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.home.component.BannerImage
import kr.co.umc.nike.presentation.home.component.NewGoodCard
import kr.co.umc.nike.presentation.home.component.NewProductBar
import kr.co.umc.nike.presentation.home.component.TopTitle
import kr.co.umc.nike.presentation.home.model.NewGood
import kr.co.umc.nike.presentation.home.viewmodel.HomeViewModel
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.presentation.util.consume
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
)  {
    val newGoodsState by viewModel.newGoodsState
        .collectAsStateWithLifecycle()

    HomeContent(newGoodsState = newGoodsState)
}

@Composable
private fun HomeContent(
    newGoodsState: UiState<List<NewGood>>
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        TopTitle(
            title = "Discover",
            today = "9월 4일 목요일",
            modifier = Modifier.padding(
                horizontal = 40.dp,
                vertical = 50.dp
            )
        )

        BannerImage(
            imageRes = R.drawable.img_banner,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        NewProductBar(
            eng = "What’s new",
            kor = "나이키 최신 상품",
            modifier = Modifier.padding(
                horizontal = 42.dp
            )
        )

        newGoodsState.consume {
            idle {
                /* Idle 처리 가능 */
            }

            loading {
                /* 로딩 컴포저블 호출 */
            }

            success { goods ->
                LazyRow(
                    contentPadding = PaddingValues(
                        vertical = 22.dp,
                        horizontal = 40.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(
                        goods,
                        key = { good -> good.id }
                    ) { good ->
                        NewGoodCard(good)
                    }
                }
            }

            error {
                /* 에러 처리 가능 */
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    NikeTheme {
        HomeContent(
            newGoodsState = UiState.Idle
        )
    }
}
