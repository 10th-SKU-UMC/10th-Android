package kr.co.umc.nike.presentation.profile.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.umc.nike.presentation.profile.component.UserInfoSection
import kr.co.umc.nike.domain.entity.Profile
import kr.co.umc.nike.presentation.bag.component.MenuBar
import kr.co.umc.nike.presentation.profile.component.EditButton
import kr.co.umc.nike.presentation.profile.component.HorizontalDivider
import kr.co.umc.nike.presentation.profile.model.Menu
import kr.co.umc.nike.presentation.profile.viewmodel.ProfileViewModel
import kr.co.umc.nike.presentation.util.UiState
import kr.co.umc.nike.presentation.util.consume
import kr.co.umc.nike.ui.theme.NikeTheme

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val profileState by viewModel.profileState.collectAsStateWithLifecycle()
    ProfileContent(profileState = profileState)
}

@Composable
private fun ProfileContent(
    profileState: UiState<List<Profile>>
) {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // 공간을 미리 차지할 박스
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            profileState.consume {
                idle {

                }

                loading {
                    // 로딩 중엔 CircularProgressIndicator 출력
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                success {
                    val profile = it.firstOrNull() ?: return@success
                    UserInfoSection(
                        profile = profile,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }

                error {
                    /* TODO: 에러 처리 */
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        EditButton(
            text = "프로필 수정",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .width(180.dp)
                .height(50.dp)
        )

        Spacer(modifier = Modifier.height(42.dp))

        MenuBar(
            items = Menu.entries
        )

        Spacer(Modifier.height(24.dp))

        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    NikeTheme {
        ProfileContent(
            profileState = UiState.Loading
        )
    }
}