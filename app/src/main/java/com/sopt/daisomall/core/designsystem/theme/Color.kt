package com.sopt.daisomall.core.designsystem.theme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White

val gray_1 = Color(0xFFF0F0F0)
val gray_2 = Color(0xFFDBDBDB)
val gray_3 = Color(0xFFBFBFBF)
val gray_4 = Color(0xFFA2A2A2)
val gray_5 = Color(0xFF868686)
val gray_6 = Color(0xFF6B6B6B)
val gray_7 = Color(0xFF5B5B5B)
val gray_8 = Color(0xFF4C4C4C)
val gray_9 = Color(0xFF3D3D3D)
val gray_10 = Color(0xFF303030)
val black = Color(0xFF191919)
val white = Color(0xFFFFFFFF)
val primary_red = Color(0xFFD70011)

@Immutable
data class DaisoColors(
    val gray_1: Color,
    val gray_2: Color,
    val gray_3: Color,
    val gray_4: Color,
    val gray_5: Color,
    val gray_6: Color,
    val gray_7: Color,
    val gray_8: Color,
    val gray_9: Color,
    val gray_10: Color,
    val black: Color,
    val White: Color,
    val primary_red: Color,
)

val defaultDaisoColors = DaisoColors(
    gray_1 = gray_1,
    gray_2 = gray_2,
    gray_3 = gray_3,
    gray_4 = gray_4,
    gray_5 = gray_5,
    gray_6 = gray_6,
    gray_7 = gray_7,
    gray_8 = gray_8,
    gray_9 = gray_9,
    gray_10 = gray_10,
    black = black,
    White = White,
    primary_red = primary_red,
)