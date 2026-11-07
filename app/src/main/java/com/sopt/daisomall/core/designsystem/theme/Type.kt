package com.sopt.daisomall.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sopt.daisomall.R

object PretendardFont {
    val bold = FontFamily(Font(R.font.pretendard_bold))
    val medium = FontFamily(Font(R.font.pretendard_medium))
    val regular = FontFamily(Font(R.font.pretendard_regular))
    val semiBold = FontFamily(Font(R.font.pretendard_semibold))
}

@Immutable
data class DaisoTypography(
    val title_b_24: TextStyle,
    val title_b_18: TextStyle,
    val body_b_16 : TextStyle,
    val body_m_16 : TextStyle,
    val body_m_14 : TextStyle,
    val body_b_14 : TextStyle,
    val body_r_14 : TextStyle,
    val body_m_12 : TextStyle,
    val body_r_12 : TextStyle,
    val body_m_11 : TextStyle,
    val caption_sb_10 : TextStyle,
    val caption_r_10 : TextStyle,
    val caption_b_10 : TextStyle,
    val caption_m_10 : TextStyle,
    val caption_b_8 : TextStyle,
)

private fun DaisoTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    letterSpacing: TextUnit,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = 1.2.em,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

val defaultDaisoTypography = DaisoTypography(
    title_b_24 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 24.sp,
        letterSpacing = (-0.04).em,
    ),
    title_b_18 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 18.sp,
        letterSpacing = (-0.01).em,
    ),
    body_b_16 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 16.sp,
        letterSpacing = (-0.02).em,
    ),
    body_m_16 = DaisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 16.sp,
        letterSpacing = (-0.04).em,
    ),
    body_m_14 = DaisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 14.sp,
        letterSpacing = (-0.02).em,
    ),
    body_b_14 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 14.sp,
        letterSpacing = (0.00).em,
    ),
    body_r_14 = DaisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 14.sp,
        letterSpacing = (-0.01).em,
    ),
    body_m_12 = DaisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 12.sp,
        letterSpacing = (-0.02).em,
    ),
    body_r_12 = DaisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 12.sp,
        letterSpacing = (-0.04).em,
    ),
    body_m_11 = DaisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 11.sp,
        letterSpacing = (0.02).em,
    ),
    caption_sb_10 = DaisoTextStyle(
        fontFamily = PretendardFont.semiBold,
        fontSize = 10.sp,
        letterSpacing = (-0.04).em,
    ),
    caption_r_10 = DaisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 10.sp,
        letterSpacing = (-0.04).em,
    ),
    caption_b_10 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 10.sp,
        letterSpacing = (-0.01).em,
    ),
    caption_m_10 = DaisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 10.sp,
        letterSpacing = (-0.01).em,
    ),
    caption_b_8 = DaisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 8.sp,
        letterSpacing = (0.00).em,
    ),
)