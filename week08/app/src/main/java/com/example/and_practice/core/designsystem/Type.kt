package com.example.and_practice.core.designsystem

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class AndPracticeTypography(
    val headlineLarge: TextStyle,
    val sectionEyebrow: TextStyle,
    val sectionTitle: TextStyle,
    val itemTitle: TextStyle,
    val itemSubtitle: TextStyle,
    val priceLabel: TextStyle,
    val bodyLarge: TextStyle
)

internal val DefaultAndPracticeTypography = AndPracticeTypography(
    headlineLarge = TextStyle(
        color = Color(0xFF000000),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 33.6.sp,
        letterSpacing = (-0.168).sp
    ),
    sectionEyebrow = TextStyle(
        color = Color(0xFF767676),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.4).sp
    ),
    sectionTitle = TextStyle(
        color = Color(0xFF000000),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.4).sp
    ),
    itemTitle = TextStyle(
        color = Color(0xFF000000),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        letterSpacing = (-0.14).sp
    ),
    itemSubtitle = TextStyle(
        color = Color(0xFF767676),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 15.6.sp,
        letterSpacing = (-0.13).sp
    ),
    priceLabel = TextStyle(
        color = Color(0xFF000000),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 16.8.sp,
        letterSpacing = (-0.14).sp
    ),
    bodyLarge = TextStyle(
        color = Color(0xFF000000),
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    )
)

internal fun AndPracticeTypography.asMaterialTypography(): Typography = Typography(
    headlineLarge = headlineLarge,
    bodyLarge = bodyLarge
)
