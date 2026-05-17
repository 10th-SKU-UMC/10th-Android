package kr.co.umc.nike.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.R
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun BannerImage(
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = "배너 이미지",
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun BannerImagePreview() {
    NikeTheme {
        BannerImage(
            imageRes = R.drawable.img_banner
        )
    }
}

