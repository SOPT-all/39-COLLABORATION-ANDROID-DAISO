package com.sopt.daisomall.presentation.stockcheck.component.cardstock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import androidx.compose.foundation.lazy.items
import com.sopt.daisomall.presentation.stockcheck.model.StockStatus
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.math.BigInteger

data class StockStore(
    val storeId: BigInteger,
    val storeName: String,
    val distanceMeters: Int,
    val stockCount: Int,
    val floor: String,
    val number: String,
    val stockStatus: StockStatus,
    val imageUrl : String,
    val isOpen : Boolean,
    val isFavoriteStore : Boolean,
)

@Composable
fun CardStock(
    stores: ImmutableList<StockStore>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(
            items = stores,
            key = { store -> store.storeId },
        ) { item ->
            CardStockItem(
                storeName = item.storeName,
                distanceMeters = item.distanceMeters,
                stockCount = item.stockCount,
                floor = item.floor,
                number = item.number,
                stockStatus = item.stockStatus,
                imageUrl = item.imageUrl,
                isOpen = item.isOpen,
                isFavoriteStore = item.isFavoriteStore,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 335, heightDp = 380)
@Composable
private fun CardStockPreview() {
    val newStores = persistentListOf(
        StockStore(
            storeId = BigInteger("12345"),
            storeName = "구로디지털단지역점",
            distanceMeters = 300,
            stockCount = 56,
            floor = "2F",
            number = "2번",
            imageUrl = "",
            isOpen = true,
            stockStatus = StockStatus.PICKUP_AVAILABLE,
            isFavoriteStore = true,
        ),
        StockStore(
            storeId = BigInteger("23456"),
            storeName = "모앱1조최고지역점",
            distanceMeters = 500,
            stockCount = 56,
            floor = "1F",
            number = "3번",
            imageUrl = "",
            isOpen = false,
            stockStatus = StockStatus.PICKUP_CLOSED,
            isFavoriteStore = false,
        ),
        StockStore(
            storeId = BigInteger("34567"),
            storeName = "합세최강가만안드맞점",
            distanceMeters = 800,
            stockCount = 0,
            floor = "",
            number = "",
            imageUrl = "",
            isOpen = false,
            stockStatus = StockStatus.OUT_OF_STOCK,
            isFavoriteStore = false,
        ),
    )

    DaisoMallTheme {
        CardStock(stores = newStores)
    }
}