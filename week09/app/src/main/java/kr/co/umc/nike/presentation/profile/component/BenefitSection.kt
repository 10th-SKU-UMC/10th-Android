package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.R
import kr.co.umc.nike.ui.theme.CustomGray
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun BenefitSection(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(

        ) {
            Text(
                text = text1,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = text2,
                fontSize = 12.sp,
                color = CustomGray,
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_to_right),
                contentDescription = ""
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BenefitSectionPreview() {
    NikeTheme {
        BenefitSection(
            text1 = "나이키 멤버 혜택",
            text2 = "0개 사용 가능",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp,vertical = 32.dp)
        )
    }
}
