package com.sopt.daisomall.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoDisabledButton(
    text: String,
    modifier: Modifier,
    @DrawableRes icon: Int,
) {
    DaisoBasicButton(
        text = text,
        onClick = {},
        modifier = modifier,
        icon = icon,
        backgroundColor = DaisoTheme.colors.gray2,
        contentColor = DaisoTheme.colors.gray5,
        isEnabled = false,
    )
}

@Preview
@Composable
private fun DaisoDisabledButtonPreview() {
    DaisoMallTheme {
        DaisoDisabledButton(
            text = "온라인 구매",
            modifier = Modifier,
            icon = R.drawable.ic_shoppingbag_small_20,
        )
    }
}