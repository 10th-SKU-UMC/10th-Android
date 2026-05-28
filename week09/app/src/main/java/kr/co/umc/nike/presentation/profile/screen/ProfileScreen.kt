package kr.co.umc.nike.presentation.profile.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.co.umc.nike.presentation.profile.component.UserInfoSection
import kr.co.umc.nike.domain.entity.Profile
import kr.co.umc.nike.presentation.bag.component.MenuBar
import kr.co.umc.nike.presentation.profile.component.BenefitSection
import kr.co.umc.nike.presentation.profile.component.BottomBar
import kr.co.umc.nike.presentation.profile.component.EditButton
import kr.co.umc.nike.presentation.profile.component.FollowingBar
import kr.co.umc.nike.presentation.profile.component.HorizontalDivider
import kr.co.umc.nike.presentation.profile.component.ImageGallery
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp),
            contentAlignment = Alignment.Center
        ) {
            profileState.consume {
                idle {

                }

                loading {
                    UserInfoSection(
                        profile = null,
                        isLoading = true
                    )
                }

                success {
                    UserInfoSection(
                        profile = it.first(),
                        isLoading = false
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

        BenefitSection(
            "나이키 멤버 혜택",
            "0개 사용 가능",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp,vertical = 32.dp)
        )

        HorizontalDivider()

        FollowingBar(
            "팔로잉 (5)",
            "편집",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 28.dp)
        )

        // 이미지 리스트
        profileState.consume {
            loading {
                ImageGallery(
                    profiles = emptyList(),
                    isApiLoading = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            success {
                ImageGallery(
                    profiles = it.drop(1),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(Modifier.height(116.dp))

        BottomBar(
            text = "회원 가입일: 2025년 9월",
            modifier = Modifier.fillMaxSize()
                .background(Color.LightGray)
                .padding(horizontal = 4.dp, vertical = 18.dp)
        )

        Spacer(Modifier.height(12.dp))
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