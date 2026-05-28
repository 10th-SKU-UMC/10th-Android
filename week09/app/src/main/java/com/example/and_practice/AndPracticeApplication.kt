package com.example.and_practice

import android.app.Application
import com.example.and_practice.data.remote.TokenStorage
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndPracticeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TokenStorage.init(this)
    }
}
