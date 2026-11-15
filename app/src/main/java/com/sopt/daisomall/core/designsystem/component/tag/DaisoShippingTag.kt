package com.sopt.daisomall.core.designsystem.component.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoShippingTag(
    text: String,
    modifier: Modifier = Modifier,
) {
    DaisoBasicTag(
        text = text,
        textColor = DaisoTheme.colors.gray8,
        textStyle = DaisoTheme.typography.caption.b10,
        backgroundColor = DaisoTheme.colors.gray1,
        horizontalPadding = 6.dp,
        verticalPadding = 4.dp,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun DaisoShippingTagPreview() {
    DaisoMallTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            DaisoShippingTag(text = "택배")
            DaisoShippingTag(text = "오늘")
        }
    }
}
