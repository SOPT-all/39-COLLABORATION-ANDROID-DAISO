package com.sopt.daisomall.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoRedLineButton(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier,
    @DrawableRes icon: Int,
) {
    DaisoBasecButton(
        text=text,
        onClick=onClick,
        modifier = modifier,
        icon=icon,
        backgroundColor= DaisoTheme.colors.white,
        contentColor = DaisoTheme.colors.primaryRed,
        borderColor = DaisoTheme.colors.primaryRed,
        isEnabled = true,
    )
}

@Preview
@Composable
private fun DaisoRedLineButtonPreview(){
    DaisoMallTheme {
        DaisoRedLineButton(
            text="온라인 구매",
            onClick={},
            modifier= Modifier,
            icon=R.drawable.ic_shoppingbag_small_20,
        )
    }
}