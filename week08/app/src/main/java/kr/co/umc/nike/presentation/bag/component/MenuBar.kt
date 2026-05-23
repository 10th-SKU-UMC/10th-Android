package kr.co.umc.nike.presentation.bag.component

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.presentation.profile.component.VerticalDivider
import kr.co.umc.nike.presentation.profile.model.Menu
import kr.co.umc.nike.ui.theme.NikeTheme

/**
 * 구분선으로 구분된 메뉴 항목 목록을 표시하는 가로 바입니다.
 *
 * @param items 바에 표시될 [Menu] 항목 리스트입니다.
 * @param modifier Row 레이아웃에 적용할 [Modifier]입니다.
 * @param divider 항목 사이에 표시될 구분선 컴포저블 함수입니다. 기본값은 [VerticalDivider]입니다.
 */
@Composable
fun MenuBar(
    items: List<Menu>,
    modifier: Modifier = Modifier,
    divider: @Composable () -> Unit = {
        VerticalDivider()
    }
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {

        items.forEachIndexed { index, item ->

            MenuItem(
                iconRes = item.iconRes,
                text = item.text,
                modifier = Modifier.weight(1f)
            )

            // 디바이더 자동 삽입
            if (index != items.lastIndex) {
                divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuBarPreview() {
    NikeTheme {
        MenuBar(
            items = listOf(
                Menu.ORDER,
                Menu.PASS,
                Menu.EVENT,
                Menu.SETTINGS
            )
        )
    }
}