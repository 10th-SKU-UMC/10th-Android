package kr.co.umc.nike.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Black,
    onPrimary = White,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = Gray100,
    onSurfaceVariant = Gray600,
    outline = Gray400
)

private val DarkColorScheme = darkColorScheme(
    primary = White,
    onPrimary = Black,
    background = Black,
    onBackground = White,
    surface = Gray800,
    onSurface = White,
    surfaceVariant = Gray800,
    onSurfaceVariant = Gray400,
    outline = Gray600
)

@Composable
fun NikeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
