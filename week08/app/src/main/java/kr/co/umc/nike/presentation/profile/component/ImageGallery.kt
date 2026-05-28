package kr.co.umc.nike.presentation.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kr.co.umc.nike.domain.entity.Profile

@Composable
fun ImageGallery(
    profiles: List<Profile>,
    modifier: Modifier = Modifier
) {

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(
            items = profiles,
            key = { it.id }
        ) { profile ->

            AsyncImage(
                model = profile.avatar,
                contentDescription = profile.name,
                modifier = Modifier.size(108.dp)
            )
        }
    }
}