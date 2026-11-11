package com.sopt.daisomall.core.designsystem.component.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoBasicTag(
    tagText: String,
    tagTextColor: Color,
    tagTextStyle: TextStyle,
    tagBackgroundColor: Color,
    horizontalPadding: Dp,
    verticalPadding: Dp,
    modifier: Modifier = Modifier,
    tagBorderColor: Color = Color.Transparent,
) {
    Text(
        text = tagText,
        modifier = modifier
            .border(width = 1.dp, color = tagBorderColor)
            .background(color = tagBackgroundColor)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        color = tagTextColor,
        style = tagTextStyle,
    )
}

@Preview
@Composable
private fun PreviewDaisoBasicTag() {
    DaisoMallTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            DaisoBasicTag(
                tagText = "택배",
                tagTextColor = DaisoTheme.colors.gray8,
                tagTextStyle = DaisoTheme.typography.caption.b10,
                tagBackgroundColor = DaisoTheme.colors.gray1,
                horizontalPadding = 6.dp,
                verticalPadding = 4.dp,
            )

            DaisoBasicTag(
                tagText = "NEW",
                tagTextColor = DaisoTheme.colors.black,
                tagTextStyle = DaisoTheme.typography.caption.sb10,
                tagBackgroundColor = DaisoTheme.colors.white,
                horizontalPadding = 3.dp,
                verticalPadding = 1.dp,
                tagBorderColor = DaisoTheme.colors.black,
            )
        }
    }
}
