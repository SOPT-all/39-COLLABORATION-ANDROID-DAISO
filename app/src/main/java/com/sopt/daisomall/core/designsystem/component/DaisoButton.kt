package com.sopt.daisomall.core.designsystem.component

import com.sopt.daisomall.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.defaultDaisoColors
import com.sopt.daisomall.core.designsystem.theme.defaultDaisoTypography

enum class ButtonType{
    RED_LINE,
    RED_FILLED,
    DISABLED,
    BLACK_LINE,
    GRAY_LINE
}

@Composable
fun DaisoButton(
    type: ButtonType,
    icon: Painter,
    text: String,
    onClick: ()-> Unit
) {
    val containerColor=when (type) {
        ButtonType.RED_LINE, ButtonType.BLACK_LINE, ButtonType.GRAY_LINE -> defaultDaisoColors.white
        ButtonType.RED_FILLED -> defaultDaisoColors.primaryRed
        ButtonType.DISABLED -> defaultDaisoColors.gray2
    }
    val contentColor = when (type) {
        ButtonType.RED_LINE -> defaultDaisoColors.primaryRed
        ButtonType.RED_FILLED -> defaultDaisoColors.white
        ButtonType.DISABLED -> defaultDaisoColors.gray5
        ButtonType.BLACK_LINE, ButtonType.GRAY_LINE -> defaultDaisoColors.gray9
    }
    val buttonBorder = when (type) {
        ButtonType.RED_FILLED, ButtonType.DISABLED -> null
        ButtonType.RED_LINE -> BorderStroke(1.dp,defaultDaisoColors.primaryRed)
        ButtonType.BLACK_LINE -> BorderStroke(1.dp,defaultDaisoColors.black)
        ButtonType.GRAY_LINE -> BorderStroke(1.dp,defaultDaisoColors.gray2)
    }
    Button(
        onClick=onClick,
        modifier = Modifier.sizeIn(minWidth = 20.dp, minHeight = 20.dp),
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor=containerColor,
            contentColor = contentColor
        ),
        border = buttonBorder,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 4.dp
        )
    ) {
        Icon(
        painter=icon,
        contentDescription=null,
            modifier = Modifier.size(20.dp)
    )
        Text(
            text = text,
            style = defaultDaisoTypography.body.m12
        )
    }

}

@Preview
@Composable
private fun DaisoButtonPreview() {
    DaisoMallTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DaisoButton(
            ButtonType.RED_LINE,
            painterResource(R.drawable.ic_shoppingbag_small_20),
            "온라인 구매",
            {}
            )
            DaisoButton(
                ButtonType.RED_FILLED,
                painterResource(R.drawable.ic_shoppingbag_small_20),
                "매장픽업",
                {}
            )
            DaisoButton(
                ButtonType.DISABLED,
                painterResource(R.drawable.ic_shoppingbag_small_20),
                "픽업미운영",
                {}
            )
            DaisoButton(
                ButtonType.BLACK_LINE,
                painterResource(R.drawable.ic_shoppingbag_small_20),
                "재입고알림",
                {}
            )
        }
    }
}