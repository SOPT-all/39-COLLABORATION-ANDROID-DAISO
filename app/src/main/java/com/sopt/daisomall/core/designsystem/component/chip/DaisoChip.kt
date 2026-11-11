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
    chipText: String,
    chipBackgroundColor: Color,
    chipTextColor: Color,
    onChipClick: () -> Unit,
    isDropdown: Boolean,
    modifier: Modifier = Modifier,
    chipBorderColor: Color = Color.Transparent,
    @DrawableRes frontIcon: Int? = null,
    @DrawableRes backIcon: Int? = null,
) {
    val hasBorder = chipBorderColor != Color.Transparent

    Row(
        modifier = modifier
            .clip(shape = CircleShape)
            .background(color = chipBackgroundColor)
            .border(1.dp, color = chipBorderColor, shape = CircleShape)
            .noRippleClickable(onClick = onChipClick)
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
            text = chipText,
            color = chipTextColor,
            style = if (isDropdown) DaisoTheme.typography.body.r14 else DaisoTheme.typography.body.m12,
        )

        if (backIcon != null) {
            Icon(
                imageVector = ImageVector.vectorResource(backIcon),
                contentDescription = null,
                tint = chipTextColor,
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
                chipText = "텍스트",
                chipBackgroundColor = DaisoTheme.colors.white,
                chipTextColor = DaisoTheme.colors.gray10,
                onChipClick = {},
                isDropdown = false,
                chipBorderColor = DaisoTheme.colors.gray1,
                frontIcon = R.drawable.ic_run_20,
            )
            // selected
            DaisoChip(
                chipText = "텍스트",
                chipBackgroundColor = DaisoTheme.colors.gray9,
                chipTextColor = DaisoTheme.colors.white,
                onChipClick = {},
                isDropdown = false,
                backIcon = R.drawable.ic_close_20,
            )
            // dropdown
            DaisoChip(
                chipText = "텍스트",
                chipBackgroundColor = Color.Transparent,
                chipTextColor = DaisoTheme.colors.gray10,
                onChipClick = {},
                isDropdown = false,
                chipBorderColor = DaisoTheme.colors.gray1,
                backIcon = R.drawable.ic_arrow_down_18,
            )
            // dropdown_grey
            DaisoChip(
                chipText = "텍스트",
                chipBackgroundColor = DaisoTheme.colors.gray1,
                chipTextColor = DaisoTheme.colors.black,
                onChipClick = {},
                isDropdown = false,
                backIcon = R.drawable.ic_arrow_down_18,
            )
        }
    }
}
