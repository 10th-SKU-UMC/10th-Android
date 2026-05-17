package kr.co.umc.nike.presentation.bag.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.bag.component.BottomActionButton
import kr.co.umc.nike.presentation.bag.component.NonePlaceHolder
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun BagScreen(
    hasProducts: Boolean = false,
    onOrderClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (hasProducts) {
            /* 추후 구현 예정 */
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                NonePlaceHolder(
                    modifier = Modifier.align(Alignment.Center),
                    iconRes = R.drawable.bag_circle,
                    text = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다."
                )
            }
        }

        BottomActionButton(
            text = "주문하기",
            onClick =  onOrderClick, //구매하기 화면으로 이동
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 40.dp, vertical = 22.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BagScreenPreview() {
    NikeTheme {
        BagScreen(
            hasProducts = false,
            onOrderClick = {}
        )
    }
}
