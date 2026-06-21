package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import kr.co.umc.nike.R
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.umc.nike.ui.theme.NikeTheme
import kr.co.umc.nike.domain.entity.Profile
import kr.co.umc.nike.presentation.util.shimmerEffect

@Composable
fun UserInfoSection(
    profile: Profile?,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isLoading) {
            Box(
                modifier = Modifier
                    .size(84.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
        } else {
            AsyncImage(
                model = profile?.avatar,
                contentDescription = profile?.name,
                placeholder = painterResource(id = R.drawable.img_profile_placeholder),
                modifier = Modifier
                    .size(84.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(Modifier.height(16.dp))

        if (isLoading) {
            Box(
                modifier = Modifier
                    .width(120.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .shimmerEffect()
            )
        } else {
            Text(
                text = profile?.name.orEmpty(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserInfoSectionPreview() {
    NikeTheme {
        UserInfoSection(
            profile = Profile(
                id = 1,
                email = "test@example.com",
                name = "닉네임",
                avatar = "https://example.com/avatar.png"
            ),
            isLoading = true
        )
    }
}