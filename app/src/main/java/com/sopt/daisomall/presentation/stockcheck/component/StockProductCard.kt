package com.sopt.daisomall.presentation.stockcheck.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.component.image.UrlImage
import com.sopt.daisomall.core.designsystem.component.tag.DaisoShippingTag
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun StockProductCard(
    imageUrl: String,
    title: String,
    price: String,
    productCode: Int,
    modifier: Modifier = Modifier,
) {
    Row( modifier = modifier.padding(all = 10.dp), ) {
        UrlImage(
            url = imageUrl,
            modifier = Modifier.size(width = 82.dp, height = 111.dp),
        )

        Spacer(modifier = Modifier.width(10.dp))

        ProductInfo(
            title = title,
            price = price,
            productCode = productCode,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ProductInfo(
    title: String,
    price: String,
    productCode: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = price,
                    color = DaisoTheme.colors.gray10,
                    style = DaisoTheme.typography.body.b14,
                )

                Text(
                    text = "원",
                    color = DaisoTheme.colors.gray10,
                    style = DaisoTheme.typography.body.sb12,
                )
            }

            Text(
                text = title,
                color = DaisoTheme.colors.gray10,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = DaisoTheme.typography.body.m12,
            )

            Row {
                Text(
                    text = productCode.toString(),
                    color = DaisoTheme.colors.gray5,
                    style = DaisoTheme.typography.caption.m10,
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = "품번",
                    color = DaisoTheme.colors.gray5,
                    style = DaisoTheme.typography.caption.m10,
                )
            }

            Row {
                DaisoShippingTag(text = "택배")

                Spacer(modifier = Modifier.width(2.dp))

                DaisoShippingTag(text = "오늘")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        //버튼
    }
}

@Preview(showBackground = true)
@Composable
private fun StockProductCardPreview() {
    DaisoMallTheme {
        StockProductCard(
            imageUrl = "",
            title = "[화잘먹/80매]마미케어 바다포도 스킨팩",
            price = "5,000",
            productCode = 1075034,
            modifier = Modifier.width(336.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StockProductCardTwoLinePreview() {
    DaisoMallTheme {
        StockProductCard(
            imageUrl = "",
            title = "[화잘먹/80매]마미케어 바다포도 스킨팩 대용량 기획세트 수분 진정 시트 마스크",
            price = "5,000",
            productCode = 1075034,
            modifier = Modifier.width(336.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StockProductCardEllipsisPreview() {
    DaisoMallTheme {
        StockProductCard(
            imageUrl = "",
            title = "[화잘먹/80매]마미케어 바다포도 스킨팩 대용량 기획세트 수분 진정 시트 마스크 촉촉 보습 데일리 케어 피부결 정돈 1+1 한정 특가 구성",
            price = "5,000",
            productCode = 1075034,
            modifier = Modifier.width(336.dp),
        )
    }
}
