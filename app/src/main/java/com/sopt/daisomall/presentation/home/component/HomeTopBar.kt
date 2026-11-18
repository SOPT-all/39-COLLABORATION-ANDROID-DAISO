package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.textfield.DaisoToggleTextField
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun HomeTopBar(
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .background(color = DaisoTheme.colors.white),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
        ) {
            TopBarChip(text = "홈", isSelected = true)
            TopBarChip(text = "뷰티&헬스")
            TopBarChip(text = "패션")
            TopBarChip(text = "신상")
            TopBarChip(text = "멤버십")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            DaisoToggleTextField(
                state = rememberTextFieldState(),
                placeholder = "상품, 품번, 브랜드 검색",
                onSearch = onSearch,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
    }

@Preview
@Composable
private fun HomeTopBarPreview() {
    DaisoMallTheme {
        HomeTopBar(
            onSearch = {},
        )
    }
}
