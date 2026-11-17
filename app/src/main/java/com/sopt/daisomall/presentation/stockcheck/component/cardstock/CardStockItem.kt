package com.sopt.daisomall.presentation.stockcheck.component.cardstock

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.draw.alpha
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

@Composable
fun CardStockItem(
    storeName: String,
    distanceMeters: Int,
    stockCount: Int,
    floor: String,
    number: String,
    stockStatus: StockStatus,
    imageUrl: String,
    isOpen : Boolean,
    isFavoriteStore : Boolean,
    modifier: Modifier = Modifier,
) {
    var isEnabled by remember { mutableStateOf(false) }
    val hasStock = stockCount >= 1

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        CardimgProduct(
            imageUrl = imageUrl,
            isOpen = isOpen,
            modifier = Modifier.size(width = 82.dp, height = 110.dp),
        )

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
                        text = storeName,
                        color = DaisoTheme.colors.gray10,
                        style = DaisoTheme.typography.body.b16,
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "${distanceMeters}m",
                        color = DaisoTheme.colors.gray6,
                        style = DaisoTheme.typography.caption.r10,
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector =
                        if (isFavoriteStore) {
                        ImageVector.vectorResource(R.drawable.ic_bookmark_pressed_24)
                    } else {
                        ImageVector.vectorResource(R.drawable.ic_bookmark_default_24)
                    },
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .noRippleClickable(
                            isEnabled = !isEnabled,
                            onClick = TODO()
                        )
                )
            }
            Text(
                text = if (hasStock) {"재고 ${stockCount}개 이하" } else {"일시품절"},
                color = if (hasStock) DaisoTheme.colors.primaryRed else DaisoTheme.colors.gray6,
                style = DaisoTheme.typography.body.sb12,
            )

            Spacer(modifier = Modifier.height(6.dp))

            LocationTag(
                floor = floor,
                number = number,
                modifier = Modifier.alpha(if (hasStock) 1f else 0f)
            )

            Spacer(modifier = Modifier.weight(1f))

            when (stockStatus) {
                StockStatus.PICKUP_AVAILABLE -> {
                    DaisoButton(
                        type = ButtonType.RED_FILLED,
                        text = "매장픽업",
                        onClick = {},
                        icon = R.drawable.ic_shoppingbag_small_20,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }

                StockStatus.PICKUP_CLOSED -> {
                    DaisoButton(
                        type = ButtonType.DISABLED,
                        text = "픽업미운영",
                        onClick = {},
                        icon = R.drawable.ic_shoppingbag_small_20,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }

                StockStatus.OUT_OF_STOCK -> {
                    DaisoButton(
                        type = ButtonType.BLACK_LINE,
                        text = "재입고알림",
                        onClick = {},
                        icon = R.drawable.ic_bell_20,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 335, name = "영업중 & 북마크 O & 재고 O")
@Composable
private fun CardStockItemAvailablePreview() {
    DaisoMallTheme {
        CardStockItem(
            storeName = "구로디지털단지지역점",
            distanceMeters= 300,
            stockCount = 56,
            floor = "2F",
            number = "2번",
            stockStatus = StockStatus.PICKUP_AVAILABLE,
            isOpen = true,
            imageUrl = "",
            isFavoriteStore = true,
            modifier = Modifier.width(247.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 335, name = "영업종료 & 북마크 x & 재고 O")
@Composable
private fun CardStockItemClosePreview() {
    DaisoMallTheme {
        CardStockItem(
            storeName = "구로디지털단지지역점",
            distanceMeters= 300,
            stockCount = 56,
            floor = "2F",
            number = "2번",
            stockStatus = StockStatus.PICKUP_CLOSED,
            isOpen = false,
            imageUrl = "",
            isFavoriteStore = false,
            modifier = Modifier.width(247.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 335, name = "영업종료 & 일시품절 O")
@Composable
private fun CardStockItemOutPreview() {
    DaisoMallTheme {
        CardStockItem(
            storeName = "구로디지털단지지역점",
            distanceMeters= 300,
            stockCount = 0,
            floor = "2F",
            number = "2번",
            stockStatus = StockStatus.OUT_OF_STOCK,
            isOpen = false,
            imageUrl = "",
            isFavoriteStore = false,
            modifier = Modifier.width(247.dp),
        )
    }
}