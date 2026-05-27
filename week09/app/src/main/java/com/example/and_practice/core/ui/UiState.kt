package com.example.and_practice.core.ui

import com.example.and_practice.data.remote.api.ApiError

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val error: ApiError) : UiState<Nothing>()
}
