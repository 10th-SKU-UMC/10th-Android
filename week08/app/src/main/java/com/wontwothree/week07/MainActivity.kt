package com.wontwothree.week07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wontwothree.week07.navigation.AppDestination
import com.wontwothree.week07.navigation.NavGraph
import com.wontwothree.week07.ui.components.BottomNavBar
import com.wontwothree.week07.ui.screens.MainScreen
import com.wontwothree.week07.ui.theme.Week07Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week07Theme {
                MainScreen()
            }
        }
    }
}
