package com.sopt.daisomall.core.designsystem.component.button

import androidx.compose.ui.graphics.Color
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

enum class ButtonType{
    RED_LINE,
    RED_FILLED,
    DISABLED,
    BLACK_LINE,
    GRAY_LINE
}

@Composable
fun DaisoBasecButton(
    text: String,
    onClick: ()-> Unit,
    modifier: Modifier,
    @DrawableRes icon: Int,
    backgroundColor: Color,
    contentColor: Color,
    borderColor: Color? = null,
    textStyle: TextStyle = DaisoTheme.typography.body.m12,
    isEnabled: Boolean = true,

    ) {

    Row(
        modifier=modifier
            .run {
                if (borderColor != null) {
                    border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(2.dp),
                    )
                } else {
                    this
                }
            }
            .clip(RoundedCornerShape(2.dp))
            .background(backgroundColor)
            .noRippleClickable(isEnabled = isEnabled, onClick=onClick)
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id=icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint=contentColor,
        )

        Text(
            text = text,
            color= contentColor,
            style = textStyle,
        )
    }
    }



@Preview

@Composable
private fun DaisoRedFilledButtonPreview() {
    DaisoMallTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DaisoRedLineButton(
                text = "온라인 구매",
                onClick = {},
                modifier = Modifier,
                icon = R.drawable.ic_shoppingbag_small_20,
            )

            DaisoRedFilledButton(
                text = "매장픽업",
                onClick = {},
                modifier = Modifier,
                icon = R.drawable.ic_shoppingbag_small_20,
            )
            DaisoDisabledButton(
                text = "온라인 구매",
                modifier = Modifier,
                icon = R.drawable.ic_shoppingbag_small_20,
            )
            DaisoBlackLineButton(
                text = "재입고알림",
                onClick = {},
                modifier = Modifier,
                icon = R.drawable.ic_bell_20,
            )
            DaisoGrayLineButton(
                text = "담기",
                onClick = {},
                modifier = Modifier,
                icon = R.drawable.ic_availablestores_20,
            )
            DaisoGrayLineButton(
                text = "구매가능 매장찾기",
                onClick = {},
                modifier = Modifier,
                icon = R.drawable.ic_availablestores_20,
            )
        }
    }
}