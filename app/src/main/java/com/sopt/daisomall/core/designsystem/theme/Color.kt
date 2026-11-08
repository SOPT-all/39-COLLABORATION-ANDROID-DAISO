package com.sopt.daisomall.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val gray1 = Color(0xFFF0F0F0)
private val gray2 = Color(0xFFDBDBDB)
private val gray3 = Color(0xFFBFBFBF)
private val gray4 = Color(0xFFA2A2A2)
private val gray5 = Color(0xFF868686)
private val gray6 = Color(0xFF6B6B6B)
private val gray7 = Color(0xFF5B5B5B)
private val gray8 = Color(0xFF4C4C4C)
private val gray9 = Color(0xFF3D3D3D)
private val gray10 = Color(0xFF303030)
private val black = Color(0xFF191919)
private val white = Color(0xFFFFFFFF)
private val primaryRed = Color(0xFFD70011)

@Immutable
data class DaisoColors(
    val gray1: Color,
    val gray2: Color,
    val gray3: Color,
    val gray4: Color,
    val gray5: Color,
    val gray6: Color,
    val gray7: Color,
    val gray8: Color,
    val gray9: Color,
    val gray10: Color,
    val black: Color,
    val white: Color,
    val primaryRed: Color,
)

val defaultDaisoColors = DaisoColors(
    gray1 = gray1,
    gray2 = gray2,
    gray3 = gray3,
    gray4 = gray4,
    gray5 = gray5,
    gray6 = gray6,
    gray7 = gray7,
    gray8 = gray8,
    gray9 = gray9,
    gray10 = gray10,
    black = black,
    white = white,
    primaryRed = primaryRed,
)


@Preview(showBackground = true)
@Composable
private fun DaisoColorPreview() {
    DaisoMallTheme {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val colors = listOf(
                "gray1" to DaisoTheme.colors.gray1,
                "gray2" to DaisoTheme.colors.gray2,
                "gray3" to DaisoTheme.colors.gray3,
                "gray4" to DaisoTheme.colors.gray4,
                "gray5" to DaisoTheme.colors.gray5,
                "gray6" to DaisoTheme.colors.gray6,
                "gray7" to DaisoTheme.colors.gray7,
                "gray8" to DaisoTheme.colors.gray8,
                "gray9" to DaisoTheme.colors.gray9,
                "gray10" to DaisoTheme.colors.gray10,
                "black" to DaisoTheme.colors.black,
                "white" to DaisoTheme.colors.white,
                "primaryRed" to DaisoTheme.colors.primaryRed,
            )

            colors.forEach { (name, color) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(color)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFD1D1D1),
                            ),
                    )

                    Text(text = name)
                }
            }
        }
    }
}
