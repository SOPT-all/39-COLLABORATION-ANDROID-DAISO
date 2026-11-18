package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme

@Composable
fun HomeQuickMenuRow(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            QuickMenuItem(image = R.drawable.img_quickbanner1, text = "다이소핫템")
            QuickMenuItem(image = R.drawable.img_quickbanner2, text = "랭킹")
            QuickMenuItem(image = R.drawable.img_quickbanner3, text = "기획전")
            QuickMenuItem(image = R.drawable.img_quickbanner4, text = "신상")
            QuickMenuItem(image = R.drawable.img_quickbanner6, text = "오늘배송")
        }
    }
    }

@Preview
@Composable
private fun HomeQuickMenuRowPreview() {
    DaisoMallTheme {
        HomeQuickMenuRow(modifier = Modifier.width(375.dp))
    }
}
