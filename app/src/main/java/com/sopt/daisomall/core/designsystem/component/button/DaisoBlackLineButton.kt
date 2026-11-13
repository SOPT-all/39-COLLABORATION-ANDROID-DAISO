package com.sopt.daisomall.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoBlackLineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    @DrawableRes icon: Int,
) {
    DaisoBasicButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        icon = icon,
        backgroundColor = DaisoTheme.colors.white,
        contentColor = DaisoTheme.colors.gray9,
        borderColor = DaisoTheme.colors.gray10,
        isEnabled = true,
    )
}

@Preview
@Composable
private fun DaisoBlackLineButtonPreview() {
    DaisoMallTheme {
        DaisoBlackLineButton(
            text = "재입고알림",
            onClick = {},
            modifier = Modifier,
            icon = R.drawable.ic_bell_20,
        )
    }
}