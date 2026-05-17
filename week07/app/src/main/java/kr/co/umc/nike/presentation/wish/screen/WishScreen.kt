package kr.co.umc.nike.presentation.wish.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.presentation.wish.component.Title

@Composable
fun WishScreen()  {
    LazyColumn{
        item{
            Title("위시리스트")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WishScreenPreview() {
    WishScreen()
}