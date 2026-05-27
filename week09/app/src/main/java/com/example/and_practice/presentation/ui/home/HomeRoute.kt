package com.example.and_practice.presentation.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.and_practice.core.ui.UiState
import com.example.and_practice.presentation.ui.purchase.FavoriteViewModel

@Composable
fun HomeRoute(
    title: String,
    viewModel: HomeViewModel = hiltViewModel(),
    favoriteViewModel: FavoriteViewModel,
    onProductClick: (Int) -> Unit = {}
) {
    val wrapper by viewModel.uiState.collectAsState()
    // HomeViewModel은 항상 Success — Loading/Error 상태 없음
    val uiState = (wrapper as? UiState.Success)?.data ?: HomeUiState()

    LaunchedEffect(title) {
        viewModel.updateHome(title)
    }

    HomeScreen(
        uiState = uiState,
        onProductClick = onProductClick
    )
}
