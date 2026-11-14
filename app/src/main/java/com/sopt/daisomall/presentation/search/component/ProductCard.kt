package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.component.image.DaisoProductImage
import com.sopt.daisomall.core.designsystem.component.tag.DaisoNewTag
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun ProductCard(
    productNumber: String,
    productName: String,
    price: String,
    imageUrl: String,
    reviewCount: String,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        DaisoProductImage(
            imageUrl = imageUrl,
            width = 112.dp,
            height = 148.dp,
            onLikeClick = onLikeClick,
            isLiked = isLiked,
        )

        Column(
            modifier = Modifier.weight(1f),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = price,
                        style = DaisoTheme.typography.title.b18,
                        color = DaisoTheme.colors.gray10,
                    )

                    Text(
                        text = "원",
                        style = DaisoTheme.typography.body.b16,
                        color = DaisoTheme.colors.gray10,
                    )
                }

                DaisoNewTag()
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = productName,
                style = DaisoTheme.typography.body.sb12,
                color = DaisoTheme.colors.gray10,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row {
                Text(
                    text = "품번",
                    style = DaisoTheme.typography.caption.m10,
                    color = DaisoTheme.colors.gray5,
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = productNumber,
                    style = DaisoTheme.typography.caption.m10,
                    color = DaisoTheme.colors.gray5,
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_stars_60),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )

                Text(
                    text = reviewCount,
                    style = DaisoTheme.typography.caption.r10,
                    color = DaisoTheme.colors.gray10,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // TODO: 구매가능 매장찾기 버튼 컴포넌트 머지 후 추가
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    DaisoMallTheme {
        Column {
            ProductCard(
                productNumber = "1075034",
                productName = "[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입[생기충전]VT PDRN 톤온 젤리 시트 마스크 1매입",
                price = "1,000",
                imageUrl = "",
                reviewCount = "9,999+",
                isLiked = false,
                onLikeClick = {},
                modifier = Modifier.padding(20.dp),
            )

            ProductCard(
                productNumber = "1075034",
                productName = "VT PDRN 톤온 젤리 시트 마스크 1매입",
                price = "1,000",
                imageUrl = "",
                reviewCount = "1200",
                isLiked = true,
                onLikeClick = {},
                modifier = Modifier.padding(20.dp),
            )
        }
    }
}
