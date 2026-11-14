package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import androidx.compose.foundation.lazy.items

data class StockStore(
    val id: Int,
    val store: String,
    val distanceMeters: Int,
    val stockCount: Int,
    val floor: String,
    val number: String,
    val stockStatus: StockStatus,
)

@Composable
fun CardStock(
    stores: List<StockStore>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(
            items = stores,
            key = { store -> store.id },
        ) { item ->
            CardStockItem(
                store = item.store,
                distanceMeters = item.distanceMeters,
                stockCount = item.stockCount,
                floor = item.floor,
                number = item.number,
                stockStatus = item.stockStatus,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 247, heightDp = 380)
@Composable
private fun CardStockPreview() {
    val newStores = listOf(
        StockStore(
            id = 1,
            store = "구로디지털단지역점",
            distanceMeters = 300,
            stockCount = 46,
            floor = "2F",
            number = "2번",
            stockStatus = StockStatus.PICKUP_AVAILABLE,
        ),
        StockStore(
            id = 2,
            store = "모앱1조최고지역점",
            distanceMeters = 500,
            stockCount = 12,
            floor = "1F",
            number = "3번",
            stockStatus = StockStatus.PICKUP_CLOSED,
        ),
        StockStore(
            id = 3,
            store = "합세최강가만안드맞점",
            distanceMeters = 800,
            stockCount = 0,
            floor = "",
            number = "",
            stockStatus = StockStatus.OUT_OF_STOCK,
        ),
    )

    DaisoMallTheme {
        CardStock(stores = newStores)
    }
}