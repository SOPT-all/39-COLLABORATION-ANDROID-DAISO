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
    text: String,
    textColor: Color,
    textStyle: TextStyle,
    backgroundColor: Color,
    horizontalPadding: Dp,
    verticalPadding: Dp,
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Transparent,
) {
    Text(
        text = text,
        modifier = modifier
            .border(width = 1.dp, color = borderColor)
            .background(color = backgroundColor)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding),
        color = textColor,
        style = textStyle,
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
                text = "택배",
                textColor = DaisoTheme.colors.gray8,
                textStyle = DaisoTheme.typography.caption.b10,
                backgroundColor = DaisoTheme.colors.gray1,
                horizontalPadding = 6.dp,
                verticalPadding = 4.dp,
            )

            DaisoBasicTag(
                text = "NEW",
                textColor = DaisoTheme.colors.black,
                textStyle = DaisoTheme.typography.caption.sb10,
                backgroundColor = DaisoTheme.colors.white,
                horizontalPadding = 3.dp,
                verticalPadding = 1.dp,
                borderColor = DaisoTheme.colors.black,
            )
        }
    }
}
