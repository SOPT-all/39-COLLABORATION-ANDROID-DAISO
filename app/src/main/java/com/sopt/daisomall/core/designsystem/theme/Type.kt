package com.sopt.daisomall.core.designsystem.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
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

private fun daisoTextStyle(
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
    title_b_24 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 24.sp,
        letterSpacing = (-0.04).em,
    ),
    title_b_18 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 18.sp,
        letterSpacing = (-0.01).em,
    ),
    body_b_16 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 16.sp,
        letterSpacing = (-0.02).em,
    ),
    body_m_16 = daisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 16.sp,
        letterSpacing = (-0.04).em,
    ),
    body_m_14 = daisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 14.sp,
        letterSpacing = (-0.02).em,
    ),
    body_b_14 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 14.sp,
        letterSpacing = (0.00).em,
    ),
    body_r_14 = daisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 14.sp,
        letterSpacing = (-0.01).em,
    ),
    body_m_12 = daisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 12.sp,
        letterSpacing = (-0.02).em,
    ),
    body_r_12 = daisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 12.sp,
        letterSpacing = (-0.04).em,
    ),
    body_m_11 = daisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 11.sp,
        letterSpacing = (0.02).em,
    ),
    caption_sb_10 = daisoTextStyle(
        fontFamily = PretendardFont.semiBold,
        fontSize = 10.sp,
        letterSpacing = (-0.04).em,
    ),
    caption_r_10 = daisoTextStyle(
        fontFamily = PretendardFont.regular,
        fontSize = 10.sp,
        letterSpacing = (-0.04).em,
    ),
    caption_b_10 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 10.sp,
        letterSpacing = (-0.01).em,
    ),
    caption_m_10 = daisoTextStyle(
        fontFamily = PretendardFont.medium,
        fontSize = 10.sp,
        letterSpacing = (-0.01).em,
    ),
    caption_b_8 = daisoTextStyle(
        fontFamily = PretendardFont.bold,
        fontSize = 8.sp,
        letterSpacing = 0.em,
    ),
)

@Preview(showBackground = true)
@Composable
private fun DaisoTypographyPreview() {
    DaisoMallTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "Title b24",
                style = DaisoTheme.typography.title_b_24,
            )
            Text(
                text = "Title b18",
                style = DaisoTheme.typography.title_b_18,
            )
            Text(
                text = "Body b16",
                style = DaisoTheme.typography.body_b_16,
            )
            Text(
                text = "Body m16",
                style = DaisoTheme.typography.body_m_16,
            )
            Text(
                text = "Body m14",
                style = DaisoTheme.typography.body_m_14,
            )
            Text(
                text = "Body b14",
                style = DaisoTheme.typography.body_b_14,
            )
            Text(
                text = "Body r14",
                style = DaisoTheme.typography.body_r_14,
            )
            Text(
                text = "Body m12",
                style = DaisoTheme.typography.body_m_12,
            )
            Text(
                text = "Body r12",
                style = DaisoTheme.typography.body_r_12,
            )
            Text(
                text = "Body m11",
                style = DaisoTheme.typography.body_m_11,
            )
            Text(
                text = "Caption sb10",
                style = DaisoTheme.typography.caption_sb_10,
            )
            Text(
                text = "Caption r10",
                style = DaisoTheme.typography.caption_r_10,
            )
            Text(
                text = "Caption b10",
                style = DaisoTheme.typography.caption_b_10,
            )
            Text(
                text = "Caption m10",
                style = DaisoTheme.typography.caption_m_10,
            )
            Text(
                text = "Caption b8",
                style = DaisoTheme.typography.caption_b_8,
            )
        }
    }
}