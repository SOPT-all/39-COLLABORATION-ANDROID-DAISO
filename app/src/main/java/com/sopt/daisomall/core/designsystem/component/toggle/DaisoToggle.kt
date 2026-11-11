package com.sopt.daisomall.core.designsystem.component.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
            .clip(RoundedCornerShape(10.dp))
            .background(DaisoTheme.colors.white),
    ) {
        ToggleChip(
            text = "매장",
            isSelected = true,
            modifier = Modifier.weight(1f),
        )
        ToggleChip(
            text = "온라인",
            isSelected = false,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun ToggleChip(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {

    Text(
        text = text,
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) DaisoTheme.colors.gray10 else Color.Transparent)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        color = if (isSelected) DaisoTheme.colors.white else DaisoTheme.colors.gray9,
        style = DaisoTheme.typography.body.sb12,
        textAlign = TextAlign.Center,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
private fun DaisoTogglePreview() {
    DaisoMallTheme {
        DaisoToggle(
            modifier = Modifier.width(84.dp),
        )
    }
}
