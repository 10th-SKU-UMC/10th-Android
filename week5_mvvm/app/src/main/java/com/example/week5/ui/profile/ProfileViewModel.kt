package com.example.week5.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week5.data.remote.UserData
import com.example.week5.domain.repository.RemoteProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: RemoteProfileRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadMyProfile()
        loadFollowingList()
    }

    private fun loadMyProfile() {
        viewModelScope.launch {
            repository.getUser(1)
                .onSuccess { user ->
                    _uiState.update { it.copy(me = user) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }

    private fun loadFollowingList() {
        viewModelScope.launch {
            repository.getUsers(page = 1)
                .onSuccess { users ->
                    _uiState.update { it.copy(following = users) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(error = e.message) }
                }
        }
    }
}

data class ProfileUiState(
    val me: UserData? = null,
    val following: List<UserData> = emptyList(),
    val error: String? = null
)
