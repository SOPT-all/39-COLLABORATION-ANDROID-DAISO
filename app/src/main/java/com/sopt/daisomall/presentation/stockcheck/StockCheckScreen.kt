package com.sopt.daisomall.presentation.stockcheck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.component.button.DaisoFilter
import com.sopt.daisomall.core.designsystem.component.chip.DaisoIconChip
import com.sopt.daisomall.core.designsystem.component.chip.DaisoSoldOutChip
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.stockcheck.component.CardStock
import com.sopt.daisomall.presentation.stockcheck.component.LocationDropdown
import com.sopt.daisomall.presentation.stockcheck.component.SmallSearchBar
import com.sopt.daisomall.presentation.stockcheck.component.StockProductCard
import com.sopt.daisomall.presentation.stockcheck.component.TapGroup
import com.sopt.daisomall.presentation.stockcheck.component.TitleTopBar
import com.sopt.daisomall.presentation.stockcheck.model.CardStockDummy

@Composable
fun StockCheckRoute(
    modifier: Modifier = Modifier
) {
    StockCheckScreen(
        modifier = modifier,
        isSelected = true
    )
}

@Composable
private fun StockCheckScreen(
    isSelected : Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(DaisoTheme.colors.white)
            .fillMaxSize(),
    ) {
        TitleTopBar(
            title = "매장재고 조회",
            onBackClick = {},
        )

        Spacer(modifier = Modifier.height(20.dp))

        StockProductCard(
            imageUrl = "",
            title = "[화잘먹/80매]마미케어 바다포도 스킨팩",
            price = "5,000",
            productCode = 1075034,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 여기 논의 해야함 *수정필요*
        TapGroup()

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LocationDropdown()

            Spacer(modifier = Modifier.width(8.dp))

            SmallSearchBar(
                modifier = Modifier.fillMaxWidth(),
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DaisoFilter()

            VerticalDivider(
                modifier = Modifier.height(16.dp),
                thickness = 1.dp,
                color = DaisoTheme.colors.gray2,

            )

            DaisoSoldOutChip(
                isSelected = isSelected,
                onClick = {},
            )

            DaisoIconChip(
                text = "매장픽업",
                icon = R.drawable.ic_run_20,
            )

            DaisoIconChip(
                text = "영업중",
                icon = R.drawable.ic_clock_20,
            )
        }

        Row(
            modifier = modifier
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .align(Alignment.Start),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_info_12),
                contentDescription = null,
                tint = Color.Unspecified,
            )

            Text(
                text = "실제 매장 재고와 다를 수 있습니다.",
                color = DaisoTheme.colors.gray5,
                style = DaisoTheme.typography.body.r12,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        CardStock(
            stores = CardStockDummy,
            modifier = Modifier.padding(horizontal = 20.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun StockCheckScreenPreview() {
    DaisoMallTheme {
        StockCheckScreen(isSelected = false)
    }
}
