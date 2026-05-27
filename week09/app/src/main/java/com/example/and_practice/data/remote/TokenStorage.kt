package com.example.and_practice.data.remote

import android.content.Context
import android.content.SharedPreferences

object TokenStorage {

    private const val PREF_NAME = "auth_prefs"
    private const val KEY_ACCESS_TOKEN = "access_token"
    private const val KEY_REFRESH_TOKEN = "refresh_token"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.applicationContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveTokens(accessToken: String, refreshToken: String) {
        checkInitialized()
        prefs.edit()
            .putString(KEY_ACCESS_TOKEN, accessToken)
            .putString(KEY_REFRESH_TOKEN, refreshToken)
            .apply()
    }

    fun getAccessToken(): String? {
        checkInitialized()
        return prefs.getString(KEY_ACCESS_TOKEN, null)
    }

    fun getRefreshToken(): String? {
        checkInitialized()
        return prefs.getString(KEY_REFRESH_TOKEN, null)
    }

    fun clear() {
        checkInitialized()
        prefs.edit().clear().apply()
    }

    private fun checkInitialized() {
        check(::prefs.isInitialized) { "TokenStorage.init(context) 를 먼저 호출해야 합니다." }
    }
}
