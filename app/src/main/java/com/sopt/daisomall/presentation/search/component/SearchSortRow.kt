package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.chip.DaisoDropdownChip
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun SearchSortRow(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = DaisoTheme.colors.gray1,
            )
            .padding(horizontal = 20.dp, vertical = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SoldOutCheck()

        DaisoDropdownChip(
            text = "추천순",
            isFilled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchSortRowPreview() {
    DaisoMallTheme {
        SearchSortRow()
    }
}
