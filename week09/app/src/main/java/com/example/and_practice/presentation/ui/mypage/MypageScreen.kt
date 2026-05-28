package com.example.and_practice.presentation.ui.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.designsystem.AndPracticeTheme
import com.example.and_practice.core.ui.LoadingScreen
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.presentation.ui.mypage.components.FollowingSection
import com.example.and_practice.presentation.ui.mypage.components.JoinDateSection
import com.example.and_practice.presentation.ui.mypage.components.MemberBenefitSection
import com.example.and_practice.presentation.ui.mypage.components.NavigateButtonRow
import com.example.and_practice.presentation.ui.mypage.components.NicknameEditDialog
import com.example.and_practice.presentation.ui.mypage.components.ProfileSection
import com.example.and_practice.presentation.ui.mypage.components.SectionDivider

@Composable
fun MyPageRoute(
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is MyPageEvent.UpdateNicknameSuccess ->
                    snackbarHostState.showSnackbar("저장됐어요")
                is MyPageEvent.UpdateNicknameFailed ->
                    snackbarHostState.showSnackbar(event.message)
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(snackbarData = data)
            }
        }
    ) { paddingValues ->
        MyPageScreen(
            uiState = uiState,
            onUpdateNickname = viewModel::updateNickname,
            onRetry = viewModel::retry,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun MyPageScreen(
    uiState: UiState<MyPageData>,
    onUpdateNickname: (String) -> Unit,
    onRetry: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is UiState.Loading -> LoadingScreen(modifier = modifier)
        is UiState.Error -> Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = uiState.error.defaultMessage)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onRetry) { Text("다시 시도") }
            }
        }
        is UiState.Success -> MyPageContent(
            data = uiState.data,
            onUpdateNickname = onUpdateNickname,
            modifier = modifier
        )
    }
}

@Composable
private fun MyPageContent(
    data: MyPageData,
    onUpdateNickname: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showEditDialog by remember { mutableStateOf(false) }

    if (showEditDialog) {
        NicknameEditDialog(
            currentNickname = data.nickname,
            onConfirm = { newNickname ->
                onUpdateNickname(newNickname)
                showEditDialog = false
            },
            onDismiss = { showEditDialog = false }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ProfileSection(
            nickname = data.nickname,
            profileImageUrl = data.profileImageUrl,
            onEditClick = { showEditDialog = true }
        )
        NavigateButtonRow()
        SectionDivider()
        MemberBenefitSection(benefitLabel = data.memberBenefitLabel)
        SectionDivider()
        FollowingSection(followings = data.followings)
        JoinDateSection()
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    AndPracticeTheme(dynamicColor = false) {
        MyPageScreen(
            uiState = UiState.Success(
                MyPageData(
                    nickname = "나이키러버",
                    profileImageUrl = "",
                    memberBenefitLabel = "Nike Member Since 2020",
                    followings = emptyList()
                )
            ),
            onUpdateNickname = {}
        )
    }
}
