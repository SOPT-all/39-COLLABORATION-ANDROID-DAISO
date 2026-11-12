package com.sopt.daisomall.core.designsystem.component.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun DaisoToggle(
    modifier: Modifier = Modifier,
) {
    Row (
        modifier = modifier
            .background(color = DaisoTheme.colors.white, shape = RoundedCornerShape(10.dp))
            .padding(end = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ToggleChip(text = "매장")
        Text(
            text = "온라인",
            color = DaisoTheme.colors.gray9,
            style = DaisoTheme.typography.body.sb12,
            maxLines = 1,
        )
    }
}

@Composable
private fun ToggleChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier
            .background(color = DaisoTheme.colors.gray10, shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp),
        color = DaisoTheme.colors.white,
        style = DaisoTheme.typography.body.sb12,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
private fun DaisoTogglePreview() {
    DaisoMallTheme {
        DaisoToggle()
    }
}
