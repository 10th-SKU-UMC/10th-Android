package com.example.and_practice.core.designsystem

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val LocalAndPracticeColorScheme = staticCompositionLocalOf { DefaultAndPracticeColorScheme }
private val LocalAndPracticeTypography = staticCompositionLocalOf { DefaultAndPracticeTypography }

object AndPracticeThemeTokens {
    val colorScheme: AndPracticeColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalAndPracticeColorScheme.current

    val typography: AndPracticeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAndPracticeTypography.current
}

private val DarkColorScheme = darkColorScheme(
    primary = DefaultAndPracticeColorScheme.primaryWhite,
    secondary = DefaultAndPracticeColorScheme.gray300,
    tertiary = DefaultAndPracticeColorScheme.gray600,
    background = DefaultAndPracticeColorScheme.primaryBlack,
    surface = DefaultAndPracticeColorScheme.primaryBlack,
    onPrimary = DefaultAndPracticeColorScheme.primaryBlack,
    onSecondary = DefaultAndPracticeColorScheme.primaryBlack,
    onTertiary = DefaultAndPracticeColorScheme.primaryBlack,
    onBackground = DefaultAndPracticeColorScheme.primaryWhite,
    onSurface = DefaultAndPracticeColorScheme.primaryWhite
)

private val LightColorScheme = lightColorScheme(
    primary = DefaultAndPracticeColorScheme.primaryBlack,
    secondary = DefaultAndPracticeColorScheme.gray600,
    tertiary = DefaultAndPracticeColorScheme.gray700,
    background = DefaultAndPracticeColorScheme.primaryWhite,
    surface = DefaultAndPracticeColorScheme.primaryWhite,
    onPrimary = DefaultAndPracticeColorScheme.primaryWhite,
    onSecondary = DefaultAndPracticeColorScheme.primaryWhite,
    onTertiary = DefaultAndPracticeColorScheme.primaryWhite,
    onBackground = DefaultAndPracticeColorScheme.primaryBlack,
    onSurface = DefaultAndPracticeColorScheme.primaryBlack
)

@Composable
fun AndPracticeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val customColorScheme = DefaultAndPracticeColorScheme
    val customTypography = DefaultAndPracticeTypography
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalAndPracticeColorScheme provides customColorScheme,
        LocalAndPracticeTypography provides customTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = customTypography.asMaterialTypography(),
            content = content
        )
    }
}
