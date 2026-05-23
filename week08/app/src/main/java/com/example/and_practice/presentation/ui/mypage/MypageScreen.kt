package com.example.and_practice.presentation.ui.mypage

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MyPageRoute(
    viewModel: MyPageViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    MyPageScreen(uiState = uiState)
}

@Composable
fun MyPageScreen(uiState: MyPageUiState) {
    Text(uiState.title)
}
