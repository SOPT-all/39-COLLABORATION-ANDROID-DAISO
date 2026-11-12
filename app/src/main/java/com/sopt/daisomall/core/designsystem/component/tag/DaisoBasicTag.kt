package com.sopt.daisomall.core.designsystem.component.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
