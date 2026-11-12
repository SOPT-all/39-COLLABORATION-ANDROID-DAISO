package com.sopt.daisomall.core.designsystem.component.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoSoldOutChip(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DaisoBasicChip(
        text = "품절제외",
        textColor = if (isSelected) DaisoTheme.colors.white else DaisoTheme.colors.gray10,
        textStyle = DaisoTheme.typography.body.m12,
        backgroundColor = if (isSelected) DaisoTheme.colors.gray9 else DaisoTheme.colors.white,
        onClick = onClick,
        modifier = modifier,
        borderColor = if (isSelected) Color.Transparent else DaisoTheme.colors.gray1,
        backIcon = if (isSelected) R.drawable.ic_close_20 else null,
    )
}

@Preview
@Composable
private fun DaisoSoldOutChipPreview() {
    DaisoMallTheme {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DaisoSoldOutChip(
                isSelected = true,
                onClick = {},
            )
            DaisoSoldOutChip(
                isSelected = false,
                onClick = {},
                modifier = Modifier.fillMaxHeight(),
            )
        }
    }
}
