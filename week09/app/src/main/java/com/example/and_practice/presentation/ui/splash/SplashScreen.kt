package com.example.and_practice.presentation.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.ui.UiState

@Composable
fun SplashRoute(
    onNavigateToHome: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val wrapper by viewModel.uiState.collectAsState()
    val data = (wrapper as? UiState.Success)?.data ?: SplashUiState()

    LaunchedEffect(data.shouldNavigateToHome) {
        if (data.shouldNavigateToHome) {
            onNavigateToHome()
        }
    }

    SplashScreen()
}

@Composable
fun SplashScreen() = Unit
