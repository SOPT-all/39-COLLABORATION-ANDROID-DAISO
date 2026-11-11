package com.sopt.daisomall.core.designsystem.component.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoBasicChip(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    textStyle: TextStyle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Transparent,
    @DrawableRes frontIcon: Int? = null,
    @DrawableRes backIcon: Int? = null,
) {
    val hasBorder = borderColor != Color.Transparent

    Row(
        modifier = modifier
            .background(color = backgroundColor, shape = CircleShape)
            .border(1.dp, color = borderColor, shape = CircleShape)
            .noRippleClickable(onClick = onClick)
            .padding(
                horizontal = if (hasBorder) 11.dp else 10.dp,
                vertical = if (hasBorder) 7.dp else 6.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (frontIcon != null) {
            Icon(
                imageVector = ImageVector.vectorResource(frontIcon),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }

        Text(
            text = text,
            color = textColor,
            style = textStyle,
        )

        if (backIcon != null) {
            Icon(
                imageVector = ImageVector.vectorResource(backIcon),
                contentDescription = null,
                tint = textColor,
            )
        }
    }
}
