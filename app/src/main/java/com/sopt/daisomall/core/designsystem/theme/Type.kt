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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.sopt.daisomall.R

private val Pretendard = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

@Immutable
data class DaisoTypography(
    val title: TitleStyle,
    val body: BodyStyle,
    val caption: CaptionStyle,
)

@Immutable
data class TitleStyle(
    val b24: TextStyle,
    val b18: TextStyle,
)

@Immutable
data class BodyStyle(
    val b16: TextStyle,
    val m16: TextStyle,
    val m14: TextStyle,
    val b14: TextStyle,
    val r14: TextStyle,
    val sb12: TextStyle,
    val m12: TextStyle,
    val r12: TextStyle,
    val m11: TextStyle,
)

@Immutable
data class CaptionStyle(
    val sb10: TextStyle,
    val r10: TextStyle,
    val b10: TextStyle,
    val m10: TextStyle,
    val b8: TextStyle,
)

private fun daisoTextStyle(
    fontWeight: FontWeight,
    fontSize: TextUnit,
    letterSpacing: TextUnit,
): TextStyle = TextStyle(
    fontFamily = Pretendard,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = 1.2.em,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

val defaultDaisoTypography = DaisoTypography(
    title = TitleStyle(
        b24 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            letterSpacing = (-0.04).em,
        ),
        b18 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            letterSpacing = (-0.01).em,
        ),
    ),
    body = BodyStyle(
        b16 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = (-0.02).em,
        ),
        m16 = daisoTextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            letterSpacing = (-0.04).em,
        ),
        m14 = daisoTextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = (-0.02).em,
        ),
        b14 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            letterSpacing = (0.00).em,
        ),
        r14 = daisoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = (-0.01).em,
        ),
        sb12 = daisoTextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            letterSpacing = (-0.02).em,
        ),
        m12 = daisoTextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            letterSpacing = (-0.02).em,
        ),
        r12 = daisoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = (-0.04).em,
        ),
        m11 = daisoTextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            letterSpacing = (0.02).em,
        ),
    ),
    caption = CaptionStyle(
        sb10 = daisoTextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            letterSpacing = (-0.04).em,
        ),
        r10 = daisoTextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 10.sp,
            letterSpacing = (-0.04).em,
        ),
        b10 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            letterSpacing = (-0.01).em,
        ),
        m10 = daisoTextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            letterSpacing = (-0.01).em,
        ),
        b8 = daisoTextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 8.sp,
            letterSpacing = 0.em,
        ),
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
                style = DaisoTheme.typography.title.b24,
            )
            Text(
                text = "Title b18",
                style = DaisoTheme.typography.title.b18,
            )
            Text(
                text = "Body b16",
                style = DaisoTheme.typography.body.b16,
            )
            Text(
                text = "Body m16",
                style = DaisoTheme.typography.body.m16,
            )
            Text(
                text = "Body m14",
                style = DaisoTheme.typography.body.m14,
            )
            Text(
                text = "Body b14",
                style = DaisoTheme.typography.body.b14,
            )
            Text(
                text = "Body r14",
                style = DaisoTheme.typography.body.r14,
            )
            Text(
                text = "Body sb12",
                style = DaisoTheme.typography.body.sb12,
            )
            Text(
                text = "Body m12",
                style = DaisoTheme.typography.body.m12,
            )
            Text(
                text = "Body r12",
                style = DaisoTheme.typography.body.r12,
            )
            Text(
                text = "Body m11",
                style = DaisoTheme.typography.body.m11,
            )
            Text(
                text = "Caption sb10",
                style = DaisoTheme.typography.caption.sb10,
            )
            Text(
                text = "Caption r10",
                style = DaisoTheme.typography.caption.r10,
            )
            Text(
                text = "Caption b10",
                style = DaisoTheme.typography.caption.b10,
            )
            Text(
                text = "Caption m10",
                style = DaisoTheme.typography.caption.m10,
            )
            Text(
                text = "Caption b8",
                style = DaisoTheme.typography.caption.b8,
            )
        }
    }
}
