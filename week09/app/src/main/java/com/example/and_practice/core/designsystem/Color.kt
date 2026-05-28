package com.example.and_practice.core.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class AndPracticeColorScheme(
    val primaryBlack: Color,
    val primaryWhite: Color,
    val gray100: Color,
    val gray200: Color,
    val gray300: Color,
    val gray600: Color,
    val gray700: Color,
    val warning500: Color,
    val overlayBlack60: Color,
    val errorRed: Color
)

internal val DefaultAndPracticeColorScheme = AndPracticeColorScheme(
    primaryBlack = Color(0xFF000000),
    primaryWhite = Color(0xFFFFFFFF),
    gray100 = Color(0xFFF6F6F6),
    gray200 = Color(0xFFE4E4E4),
    gray300 = Color(0xFFCDCDCD),
    gray600 = Color(0xFF767676),
    gray700 = Color(0xFF57595B),
    warning500 = Color(0xFFFC5100),
    overlayBlack60 = Color(0x993C3C43),
    errorRed = Color(0xFFFF0000)
)
