package kr.co.umc.nike.presentation.buy.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.NikeTheme

/**
 * 상단 탭 바를 표시하는 컴포저블 함수입니다.
 * 사용자가 여러 카테고리(예: 전체, 상의, 신발 등) 사이를 탐색할 수 있도록 가로 스크롤 가능한 탭 행을 제공합니다.
 *
 * @param currentTabIndex 현재 선택된 탭의 인덱스입니다.
 * @param tabs 탭에 표시될 문자열 리스트입니다.
 * @param onTabSelected 탭이 클릭되었을 때 호출되는 콜백 함수로, 클릭된 탭의 인덱스를 전달합니다.
 */
@Composable
fun TobBar(
    currentTabIndex: Int,
    tabs: List<String>,
    onTabSelected: (Int) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = currentTabIndex,
        edgePadding = 16.dp,  // 양쪽 여백 제거
        containerColor = Color.White,
        divider = {},
        indicator = { tabPositions -> // 인디케이터
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPositions[currentTabIndex])
                    .height(2.dp)
                    .background(Color.Black)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = currentTabIndex == index,
                onClick = { onTabSelected(index) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                text = {
                    Text(
                        text = title,
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier
                    .padding(horizontal = 0.dp)
                    .height(56.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TobBarPreview() {
    NikeTheme {
        TobBar(
            currentTabIndex = 0,
            tabs = listOf("전체", "Tops&T-Shirts", "Shoes"),
            onTabSelected = {}
        )
    }
}

