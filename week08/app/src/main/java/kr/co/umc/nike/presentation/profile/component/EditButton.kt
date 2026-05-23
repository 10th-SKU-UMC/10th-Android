package kr.co.umc.nike.presentation.profile.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.ui.theme.Black
import kr.co.umc.nike.ui.theme.NikeTheme
import kr.co.umc.nike.ui.theme.White

@Composable
fun EditButton(
    text: String,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick ={},
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = White
        ),
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Black,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun EditButtonPreview() {
    NikeTheme {
        EditButton(text = "프로필 수정")
    }
}