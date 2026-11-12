package com.sopt.daisomall.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoRedFilledButton(
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
        backgroundColor= DaisoTheme.colors.primaryRed,
        contentColor = DaisoTheme.colors.white,
        isEnabled = true,
    )
}

@Preview
@Composable
private fun DaisoRedFilledButtonPreview(){
    DaisoMallTheme {
        Column(

        ) {

            DaisoRedFilledButton(
                text="매장픽업",
                onClick={},
                modifier= Modifier,
                icon=R.drawable.ic_shoppingbag_small_20,
            )
        }
    }
}