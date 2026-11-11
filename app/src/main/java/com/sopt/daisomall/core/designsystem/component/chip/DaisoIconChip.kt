package com.sopt.daisomall.core.designsystem.component.chip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoIconChip(
    text: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
) {
    DaisoBasicChip(
        text = text,
        textColor = DaisoTheme.colors.gray10,
        textStyle = DaisoTheme.typography.body.m12,
        backgroundColor = DaisoTheme.colors.white,
        onClick = {},
        modifier = modifier,
        borderColor = DaisoTheme.colors.gray1,
        frontIcon = icon,
    )
}

@Preview
@Composable
private fun DaisoIconChipPreview() {
    DaisoMallTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            DaisoIconChip(
                text = "매장픽업",
                icon = R.drawable.ic_run_20,
            )
            DaisoIconChip(
                text = "영업중",
                icon = R.drawable.ic_clock_20,
            )
        }
    }
}
