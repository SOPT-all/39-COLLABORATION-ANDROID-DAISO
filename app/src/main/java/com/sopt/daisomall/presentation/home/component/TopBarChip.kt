package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun TopBarChip(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Text(
        text = text,
        modifier = modifier
            .background(
                color = if (isSelected) DaisoTheme.colors.black else DaisoTheme.colors.white,
                shape = CircleShape,
            )
            .padding(horizontal = 10.dp, vertical = 8.dp),
        color = if (isSelected) DaisoTheme.colors.white else DaisoTheme.colors.gray10,
        style = DaisoTheme.typography.body.m14,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
private fun TopBarChipPreview() {
    DaisoMallTheme {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
        ) {
            TopBarChip(text = "홈", isSelected = true)
            TopBarChip(text = "뷰티&헬스")
            TopBarChip(text = "패션")
            TopBarChip(text = "신상")
            TopBarChip(text = "멤버십")
        }
    }
}
