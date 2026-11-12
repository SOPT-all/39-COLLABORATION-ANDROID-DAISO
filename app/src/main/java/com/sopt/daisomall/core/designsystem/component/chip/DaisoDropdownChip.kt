package com.sopt.daisomall.core.designsystem.component.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoDropdownChip(
    text: String,
    isFilled: Boolean,
    modifier: Modifier = Modifier,
) {
    DaisoBasicChip(
        text = text,
        textColor = if (isFilled) DaisoTheme.colors.black else DaisoTheme.colors.gray10,
        textStyle = DaisoTheme.typography.body.r14,
        backgroundColor = if (isFilled) DaisoTheme.colors.gray1 else Color.Transparent,
        onClick = {},
        modifier = modifier,
        borderColor = if (isFilled) Color.Transparent else DaisoTheme.colors.gray1,
        backIcon = R.drawable.ic_arrow_down_18,
    )
}

@Preview
@Composable
private fun DaisoDropdownChipPreview() {
    DaisoMallTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            DaisoDropdownChip(
                text = "추천순",
                isFilled = false,
            )
            DaisoDropdownChip(
                text = "브랜드",
                isFilled = true,
            )
        }
    }
}
