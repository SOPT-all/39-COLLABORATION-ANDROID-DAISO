package com.sopt.daisomall.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun LocationTag(
    floor: String,
    number: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .border(1.dp, color = DaisoTheme.colors.gray3)
            .background(color = DaisoTheme.colors.white)
            .padding(horizontal = 4.dp, vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = floor,
            style = DaisoTheme.typography.caption.b10,
            color = DaisoTheme.colors.gray7
        )
        VerticalDivider(
            modifier = Modifier.height(10.dp).padding(horizontal = 4.dp),
            thickness = 1.dp,
            color = DaisoTheme.colors.gray3
        )
        Text(
            text = number,
            style = DaisoTheme.typography.caption.b10,
            color = DaisoTheme.colors.gray7
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LocationTagPreview() {
    DaisoMallTheme {
        LocationTag(floor = "2F",number = "2번")
    }
}