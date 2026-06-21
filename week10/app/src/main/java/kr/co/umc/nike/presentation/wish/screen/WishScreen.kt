package kr.co.umc.nike.presentation.wish.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.presentation.util.consume
import kr.co.umc.nike.presentation.wish.component.Title
import kr.co.umc.nike.presentation.wish.component.WishGoodCard
import kr.co.umc.nike.presentation.wish.model.WishGood
import kr.co.umc.nike.presentation.wish.viewmodel.WishViewModel
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun WishScreen(
    viewModel: WishViewModel = hiltViewModel()
)  {
    val wishGoodState by viewModel.wishGoodsState
        .collectAsStateWithLifecycle()
    
    WishScreenContent(wishGoodState = wishGoodState)
}

@Composable
fun WishScreenContent(
    wishGoodState: UiState<List<WishGood>>
) {
    LazyColumn{
        item {
            Title(
                text = "위시리스트",
            )
        }

        item {
            wishGoodState.consume {
                idle {
                    /* Idle 처리 가능 */
                }

                loading {
                    /* 로딩 컴포저블 호출 */
                }

                success { goods ->
                    LazyRow(
                        contentPadding = PaddingValues(
                            horizontal = 14.dp
                        ),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(
                            goods,
                            key = { good -> good.id }
                        ) { good ->
                            WishGoodCard(good)
                        }
                    }
                }

                error {
                    /* 에러 처리 가능 */
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun WishScreenPreview() {
    NikeTheme {
        WishScreenContent(
            wishGoodState = UiState.Success(
                listOf(
                    WishGood(
                        id = 1,
                        goodImage = R.drawable.img_air_force,
                        goodName = "나이키 에어 포스 1 '07",
                        description = "남성 신발",
                        colorDescription = "1개 컬러",
                        goodPrice = "139,000 원"
                    )
                )
            )
        )
    }
}

