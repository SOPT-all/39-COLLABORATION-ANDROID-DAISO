package com.sopt.daisomall.presentation.stockcheck.component.cardstock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.common.extensions.noRippleClickable
import com.sopt.daisomall.core.designsystem.component.button.ButtonType
import com.sopt.daisomall.core.designsystem.component.button.DaisoButton
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.stockcheck.component.CardimgProduct
import com.sopt.daisomall.presentation.stockcheck.component.LocationTag
import com.sopt.daisomall.presentation.stockcheck.model.StockStatus
import java.math.BigInteger

@Composable
fun CardStockItem(
    stockStore : StockStore,
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
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
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
                }

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
            // 수정 후
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

private val previewStockStore = StockStore(
    storeId = BigInteger("12345"),
    storeName = "구로디지털단지지역점",
    distanceMeters = 300,
    stockCount = 56,
    floor = "2F",
    number = "2번",
    stockStatus = StockStatus.PICKUP_AVAILABLE,
    isOpen = true,
    imageUrl = "",
    isFavoriteStore = true,
)

@Preview(showBackground = true, widthDp = 335, name = "영업중 & 북마크 O & 재고 O")
@Composable
private fun CardStockItemAvailablePreview() {
    DaisoMallTheme {
        CardStockItem(
            stockStore = previewStockStore,
            modifier = Modifier.width(247.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 335, name = "영업종료 & 북마크 x & 재고 O")
@Composable
private fun CardStockItemClosePreview() {
    DaisoMallTheme {
        CardStockItem(
            stockStore = previewStockStore.copy(
                stockStatus = StockStatus.PICKUP_CLOSED,
                isOpen = false,
                isFavoriteStore = false,
            ),
            modifier = Modifier.width(247.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 335, name = "영업종료 & 일시품절 O")
@Composable
private fun CardStockItemOutPreview() {
    DaisoMallTheme {
        CardStockItem(
            stockStore = previewStockStore.copy(
                stockCount = 0,
                stockStatus = StockStatus.OUT_OF_STOCK,
                isOpen = false,
                isFavoriteStore = false,
                floor = "",
                number = "",
            ),
            modifier = Modifier.width(247.dp),
        )
    }
}