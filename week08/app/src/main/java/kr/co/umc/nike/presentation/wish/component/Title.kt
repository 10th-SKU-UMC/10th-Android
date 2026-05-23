package kr.co.umc.nike.presentation.wish.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun Title(
    text: String
) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 42.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    NikeTheme {
        Title(text = "위시리스트")
    }
}


