package kr.co.umc.myapplication.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _selectedEmotionState = MutableStateFlow<SelectedState>(Unselected)
    val selectedEmotionState = _selectedEmotionState.asStateFlow()

    fun onSelect(state: SelectedState) {
        _selectedEmotionState.value =
            if (_selectedEmotionState.value == state) Unselected else state

    }

}