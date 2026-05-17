package kr.co.umc.nike.presentation.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kr.co.umc.nike.domain.repository.ProfileRepository
import kr.co.umc.nike.presentation.profile.model.Profile
import kr.co.umc.nike.presentation.util.UiState
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _profileState = MutableStateFlow<UiState<List<Profile>>>(UiState.Idle)
    val profileState = _profileState.asStateFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _profileState.value = UiState.Loading

            profileRepository.getFollowingUsers()
                .fold(
                    onSuccess = { profiles ->
                        _profileState.value = UiState.Success(profiles)
                    },
                    onFailure = { e ->
                        _profileState.value = UiState.Error(e.message ?: "Unknown Error")
                    }
                )
        }
    }
}
