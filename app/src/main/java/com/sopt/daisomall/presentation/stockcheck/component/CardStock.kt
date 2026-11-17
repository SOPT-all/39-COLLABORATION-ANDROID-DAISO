package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.component.button.ButtonType
import com.sopt.daisomall.core.designsystem.component.button.DaisoButton
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.stockcheck.model.StockStoreModel
import com.sopt.daisomall.presentation.stockcheck.type.StockStatus
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun CardStock(
    stores: ImmutableList<StockStoreModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(
            items = stores,
            key = { item -> item.storeId },
        ) { item ->
            CardStockItem(
                stockStore = item,
            )
        }
    }
}

@Composable
private fun CardStockItem(
    stockStore : StockStoreModel,
    modifier: Modifier = Modifier,
) {
    var isBookmarked by remember(stockStore.isFavoriteStore) {
        mutableStateOf(stockStore.isFavoriteStore)
    }
    val hasStock = stockStore.stockCount >= 1

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
    ) {
        CardimgProduct(
            imageUrl = stockStore.imageUrl,
            isOpen = stockStore.isOpen,
            modifier = Modifier.size(width = 82.dp, height = 110.dp),
        )

        Spacer(modifier = Modifier.width(6.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = stockStore.storeName,
                    color = DaisoTheme.colors.gray10,
                    style = DaisoTheme.typography.body.b16,
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${stockStore.distanceMeters}m",
                    color = DaisoTheme.colors.gray6,
                    style = DaisoTheme.typography.caption.r10,
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = ImageVector.vectorResource(
                        if (isBookmarked) {
                            R.drawable.ic_bookmark_pressed_24
                        } else {
                            R.drawable.ic_bookmark_default_24
                        }
                    ),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .noRippleClickable(
                            onClick = {
                                isBookmarked = !isBookmarked
                            },
                            isEnabled = true,
                        ),
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = if (hasStock) {"재고 ${stockStore.stockCount}개 이하" } else {"일시품절"},
                color = if (hasStock) DaisoTheme.colors.primaryRed else DaisoTheme.colors.gray6,
                style = DaisoTheme.typography.body.sb12,
            )

            if (hasStock) {
                Spacer(modifier = Modifier.height(6.dp))

                LocationTag(
                    floor = stockStore.floor,
                    number = stockStore.number,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val buttonType = when (stockStore.stockStatus) {
                StockStatus.PICKUP_AVAILABLE -> ButtonType.RED_FILLED
                StockStatus.PICKUP_CLOSED -> ButtonType.DISABLED
                StockStatus.OUT_OF_STOCK -> ButtonType.BLACK_LINE
            }

            val buttonText = when (stockStore.stockStatus) {
                StockStatus.PICKUP_AVAILABLE -> "매장픽업"
                StockStatus.PICKUP_CLOSED -> "픽업미운영"
                StockStatus.OUT_OF_STOCK -> "재입고알림"
            }

            val buttonIcon = when (stockStore.stockStatus) {
                StockStatus.PICKUP_AVAILABLE -> R.drawable.ic_shoppingbag_small_20
                StockStatus.PICKUP_CLOSED -> R.drawable.ic_shoppingbag_small_20
                StockStatus.OUT_OF_STOCK -> R.drawable.ic_bell_20
            }

            DaisoButton(
                type = buttonType,
                text = buttonText,
                onClick = {},
                icon = buttonIcon,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 335, heightDp = 380)
@Composable
private fun CardStockPreview() {
    val newStores = persistentListOf(
        StockStoreModel(
            storeId = 12345,
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
        StockStoreModel(
            storeId = 23456,
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
        StockStoreModel(
            storeId = 34567,
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