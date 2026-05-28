package com.wacaw.week09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.wacaw.week09.ui.screens.MainScreen
import com.wacaw.week09.ui.theme.Week09Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week09Theme() {
                MainScreen()
            }
        }
    }
}
