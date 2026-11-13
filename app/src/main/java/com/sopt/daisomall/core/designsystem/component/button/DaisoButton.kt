package com.sopt.daisomall.core.designsystem.component.button

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

enum class ButtonType {
    RED_LINE,
    RED_FILLED,
    DISABLED,
    BLACK_LINE,
    GRAY_LINE
}
@Composable
fun DaisoButton(
    type: ButtonType,
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier= Modifier,
    textStyle: TextStyle = DaisoTheme.typography.body.m12,
) {
    val backgroundColor = when (type) {
        ButtonType.RED_LINE, ButtonType.BLACK_LINE, ButtonType.GRAY_LINE -> DaisoTheme.colors.white
        ButtonType.RED_FILLED -> DaisoTheme.colors.primaryRed
        ButtonType.DISABLED -> DaisoTheme.colors.gray2
    }
    val contentColor = when (type) {
        ButtonType.RED_LINE -> DaisoTheme.colors.primaryRed
        ButtonType.RED_FILLED -> DaisoTheme.colors.white
        ButtonType.DISABLED -> DaisoTheme.colors.gray5
        ButtonType.BLACK_LINE, ButtonType.GRAY_LINE -> DaisoTheme.colors.gray9
    }
    val borderColor = when (type) {
        ButtonType.RED_FILLED, ButtonType.DISABLED -> null
        ButtonType.RED_LINE -> DaisoTheme.colors.primaryRed
        ButtonType.BLACK_LINE -> DaisoTheme.colors.black
        ButtonType.GRAY_LINE -> DaisoTheme.colors.gray2
    }
    val isEnabled = when (type) {
        ButtonType.DISABLED -> false
        else -> true
    }
    Row(
        modifier = modifier
            .run {
                if (borderColor != null) {
                    border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(2.dp),
                    )
                } else {
                    this
                }
            }
            .clip(RoundedCornerShape(2.dp))
            .background(backgroundColor)
            .noRippleClickable(isEnabled = isEnabled, onClick = onClick)
            .padding(
                horizontal = if (borderColor!=null) 17.dp else 16.dp,
                vertical = if (borderColor!=null) 5.dp else 4.dp
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor,
        )

        Text(
            text = text,
            color = contentColor,
            style = textStyle,
        )
    }
}

@Preview
@Composable
private fun DaisoButtonPreview() {
    DaisoMallTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DaisoButton(
                type = ButtonType.RED_LINE,
                text = "온라인 구매",
                onClick = {},
                icon = R.drawable.ic_shoppingbag_small_20,
            )

            DaisoButton(
                type = ButtonType.RED_FILLED,
                text = "매장픽업",
                onClick = {},
                icon = R.drawable.ic_shoppingbag_small_20,
            )
            DaisoButton(
                type = ButtonType.DISABLED,
                text = "픽업미운영",
                onClick = {},
                icon = R.drawable.ic_shoppingbag_small_20,
            )
            DaisoButton(
                type = ButtonType.BLACK_LINE,
                text = "재입고알림",
                onClick = {},
                icon = R.drawable.ic_bell_20,
            )
            DaisoButton(
                type = ButtonType.GRAY_LINE,
                text = "담기",
                onClick = {},
                icon = R.drawable.ic_availablestores_20,
            )
            DaisoButton(
                type = ButtonType.GRAY_LINE,
                text = "구매가능 매장찾기",
                onClick = {},
                icon = R.drawable.ic_availablestores_20,
            )
        }
    }
}
