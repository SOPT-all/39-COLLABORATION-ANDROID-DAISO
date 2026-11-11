package com.sopt.daisomall.core.designsystem.component.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoChip(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit,
    isDropdown: Boolean,
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
            style = if (isDropdown) DaisoTheme.typography.body.r14 else DaisoTheme.typography.body.m12,
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

@Preview
@Composable
private fun DaisoChipPreview() {
    DaisoMallTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            // Default
            DaisoChip(
                text = "텍스트",
                backgroundColor = DaisoTheme.colors.white,
                textColor = DaisoTheme.colors.gray10,
                onClick = {},
                isDropdown = false,
                borderColor = DaisoTheme.colors.gray1,
                frontIcon = R.drawable.ic_run_20,
            )
            // selected
            DaisoChip(
                text = "텍스트",
                backgroundColor = DaisoTheme.colors.gray9,
                textColor = DaisoTheme.colors.white,
                onClick = {},
                isDropdown = false,
                backIcon = R.drawable.ic_close_20,
            )
            // dropdown
            DaisoChip(
                text = "텍스트",
                backgroundColor = Color.Transparent,
                textColor = DaisoTheme.colors.gray10,
                onClick = {},
                isDropdown = true,
                borderColor = DaisoTheme.colors.gray1,
                backIcon = R.drawable.ic_arrow_down_18,
            )
            // dropdown_grey
            DaisoChip(
                text = "텍스트",
                backgroundColor = DaisoTheme.colors.gray1,
                textColor = DaisoTheme.colors.black,
                onClick = {},
                isDropdown = true,
                backIcon = R.drawable.ic_arrow_down_18,
            )
        }
    }
}
