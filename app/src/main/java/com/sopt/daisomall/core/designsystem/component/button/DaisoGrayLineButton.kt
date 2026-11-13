package com.sopt.daisomall.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoGrayLineButton(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier,
    @DrawableRes icon: Int,
) {
    DaisoBasicButton(
        text=text,
        onClick=onClick,
        modifier = modifier,
        icon=icon,
        backgroundColor= DaisoTheme.colors.white,
        contentColor = DaisoTheme.colors.gray9,
        borderColor = DaisoTheme.colors.gray2,
        textStyle = DaisoTheme.typography.body.sb12,
        isEnabled = true,
    )
}

@Preview
@Composable
private fun DaisoGrayLineButtonPreview(){
    DaisoMallTheme {
        DaisoGrayLineButton(
            text="담기",
            onClick={},
            modifier= Modifier,
            icon=R.drawable.ic_availablestores_20,
        )
    }
}