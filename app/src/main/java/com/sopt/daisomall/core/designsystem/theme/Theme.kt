package com.sopt.daisomall.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color.Companion.White

private val LocalDaisoColors =
    staticCompositionLocalOf { defaultDaisoColors }

private val LocalDaisoTypography =
    staticCompositionLocalOf { defaultDaisoTypography }

object DaisoTheme {
    val colors: DaisoColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDaisoColors.current

    val typography: DaisoTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDaisoTypography.current
}

private val DaisoMaterialColorScheme = lightColorScheme(
    background = White,
)

@Composable
private fun ProvideDaisoColorsAndTypography(
    colors: DaisoColors,
    typography: DaisoTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalDaisoColors provides colors,
        LocalDaisoTypography provides typography,
        content = content,
    )
}

@Composable
fun DaisoMallTheme(
    content: @Composable () -> Unit
) {
    ProvideDaisoColorsAndTypography(
        colors = defaultDaisoColors,
        typography = defaultDaisoTypography,
    ) {
        MaterialTheme(
            colorScheme = DaisoMaterialColorScheme,
            content = content,
        )
    }
}
