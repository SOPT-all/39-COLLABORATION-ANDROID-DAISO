package com.sopt.daisomall.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

private val gray_1 = Color(0xFFF0F0F0)
private val gray_2 = Color(0xFFDBDBDB)
private val gray_3 = Color(0xFFBFBFBF)
private val gray_4 = Color(0xFFA2A2A2)
private val gray_5 = Color(0xFF868686)
private val gray_6 = Color(0xFF6B6B6B)
private val gray_7 = Color(0xFF5B5B5B)
private val gray_8 = Color(0xFF4C4C4C)
private val gray_9 = Color(0xFF3D3D3D)
private val gray_10 = Color(0xFF303030)
private val black = Color(0xFF191919)
private val white = Color(0xFFFFFFFF)
private val primary_red = Color(0xFFD70011)

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
    val white: Color,
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
    white = white,
    primary_red = primary_red,
)