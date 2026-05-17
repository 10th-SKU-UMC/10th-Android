package kr.co.umc.nike.presentation.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.umc.nike.R
import kr.co.umc.nike.presentation.home.component.BannerImage
import kr.co.umc.nike.presentation.home.component.TopTitle

@Composable
fun HomeScreen()  {

    LazyColumn {

        item {
            TopTitle(
                title = "Discover",
                today = "9월 4일 목요일",
                modifier = Modifier.padding(
                    horizontal = 40.dp,
                    vertical = 50.dp
                )
            )
        }

        item {
            BannerImage(
                imageRes = R.drawable.img_banner,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}