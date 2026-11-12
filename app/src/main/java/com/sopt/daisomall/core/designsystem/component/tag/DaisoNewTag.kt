package com.sopt.daisomall.core.designsystem.component.tag

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoNewTag(
    modifier: Modifier = Modifier,
) {
    DaisoBasicTag(
        text = "NEW",
        textColor = DaisoTheme.colors.black,
        textStyle = DaisoTheme.typography.caption.sb10,
        backgroundColor = DaisoTheme.colors.white,
        horizontalPadding = 3.dp,
        verticalPadding = 1.dp,
        modifier = modifier,
        borderColor = DaisoTheme.colors.black,
    )
}

@Preview
@Composable
private fun DaisoNewTagPreview() {
    DaisoMallTheme {
        DaisoNewTag()
    }
}
