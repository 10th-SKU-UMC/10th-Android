package com.example.and_practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.and_practice.core.designsystem.AndPracticeTheme
import com.example.and_practice.core.ui.BaseActivity
import com.example.and_practice.data.remote.SessionManager
import com.example.and_practice.data.remote.TokenStorage
import com.example.and_practice.presentation.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndPracticeTheme {
                MainScreen()
            }
        }
        observeSessionEvent()
    }

    private fun observeSessionEvent() {
        lifecycleScope.launch {
            sessionManager.loginEvent.collect {
                // 토큰 만료 → 스플래시로 이동해서 재로그인
                // TODO: 로그인 화면이 생기면 여기서 navigate
                TokenStorage.clear()
                navController
            }
        }
    }
}
