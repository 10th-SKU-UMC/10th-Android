package kr.co.umc.nike.presentation.buy.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.umc.nike.R
import kr.co.umc.nike.ui.theme.NikeTheme
import kr.co.umc.nike.ui.theme.White


@Composable
fun HeartCircle(
    isLiked: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(White)
    ) {
        Image(
            painter = painterResource(
                if (isLiked)
                    R.drawable.filled_heart
                else
                    R.drawable.empty_heart
            ),
            contentDescription = "",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeartCirclePreview() {
    NikeTheme {
        HeartCircle(
            isLiked = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeartCircleUnLikedPreview() {
    NikeTheme {
        HeartCircle(
            isLiked = false,
        )
    }
}

