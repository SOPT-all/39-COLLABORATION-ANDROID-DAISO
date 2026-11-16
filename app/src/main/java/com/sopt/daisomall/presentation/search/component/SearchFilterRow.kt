package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.button.DaisoFilter
import com.sopt.daisomall.core.designsystem.component.chip.DaisoBasicChip
import com.sopt.daisomall.core.designsystem.component.chip.DaisoDropdownChip
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

private val filterChipLabels = listOf("브랜드", "카테고리", "별점")

@Composable
fun SearchFilterRow(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        DaisoFilter()

        VerticalDivider(
            modifier = Modifier.height(15.dp),
            thickness = 1.dp,
            color = DaisoTheme.colors.gray4,
        )

        DaisoBasicChip(
            text = "NEW",
            textColor = DaisoTheme.colors.gray10,
            textStyle = DaisoTheme.typography.body.r14,
            backgroundColor = Color.Transparent,
            onClick = {},
            borderColor = DaisoTheme.colors.gray1,
        )

        filterChipLabels.forEach { label ->
            DaisoDropdownChip(
                text = label,
                isFilled = true,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchFilterRowPreview() {
    DaisoMallTheme {
        SearchFilterRow()
    }
}
