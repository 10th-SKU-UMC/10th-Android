package kr.co.umc.nike.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kr.co.umc.nike.navigation.model.BottomBarItem
import kr.co.umc.nike.navigation.route.MainDestination
import kotlin.enums.EnumEntries

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    items: EnumEntries<BottomBarItem>, // 적용할 ui 모델
    currentDestination: MainDestination?, // 현재 선택된 탭
    onNavigate: (MainDestination) -> Unit // 클릭 이벤트 콜백
) {

    CompositionLocalProvider(
        LocalRippleConfiguration provides null // 리플효과 제거
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            // 내비게이션 바에 각 탭 배치
            items.forEach { item ->
                NavigationBarItem(
                    selected = item.destination == currentDestination,
                    onClick = { onNavigate(item.destination) },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent
                    ),
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label
                        )
                    },
                    label = { Text(item.label) }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun BottomBarPreview() {
//    val items = listOf(
//        BottomBarItem(MainDestination.Home, R.drawable.house_simple, "홈"),
//        BottomBarItem(MainDestination.Buy, R.drawable.list_magnifying_glass, "구매"),
//        BottomBarItem(MainDestination.WishList, R.drawable.heart_straight, "위시리스트"),
//        BottomBarItem(MainDestination.Bag, R.drawable.bag_simple, "장바구니"),
//        BottomBarItem(MainDestination.Profile, R.drawable.user, "프로필")
//    )
//    NikeTheme {
//        BottomBar(
//            items = items,
//            currentDestination = MainDestination.Home,
//            onNavigate = {}
//        )
//    }
//}
