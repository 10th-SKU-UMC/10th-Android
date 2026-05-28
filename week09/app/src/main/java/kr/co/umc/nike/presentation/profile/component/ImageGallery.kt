package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import kr.co.umc.nike.domain.entity.Profile
import kr.co.umc.nike.presentation.util.shimmerEffect
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun ImageGallery(
    profiles: List<Profile>,
    modifier: Modifier = Modifier,
    isApiLoading: Boolean = false,
) {

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        if (isApiLoading) {

            items(5) {

                Box(
                    modifier = Modifier
                        .size(108.dp)
                        .shimmerEffect()
                )
            }

        } else {

            items(
                items = profiles,
                key = { it.id }
            ) { profile ->

                SubcomposeAsyncImage(
                    model = profile.avatar,
                    contentDescription = profile.name,

                    loading = {
                        Box(
                            modifier = Modifier
                                .size(108.dp)
                                .shimmerEffect()
                        )
                    },

                    modifier = Modifier.size(108.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageGalleryPreview() {
    NikeTheme {
        ImageGallery(
            profiles = listOf(
                Profile(1, "test1@gmail.com", "User 1", ""),
                Profile(2, "test2@gmail.com", "User 2", ""),
                Profile(3, "test3@gmail.com", "User 3", ""),
                Profile(4, "test4@gmail.com", "User 4", ""),
                Profile(5, "test5@gmail.com", "User 5", "")
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageGalleryLoadingPreview() {
    NikeTheme {
        ImageGallery(
            profiles = emptyList(),
            isApiLoading = true
        )
    }
}