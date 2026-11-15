package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.R
import com.sopt.daisomall.core.designsystem.component.button.ButtonType
import com.sopt.daisomall.core.designsystem.component.image.DaisoProductImage
import com.sopt.daisomall.core.designsystem.component.button.DaisoButton
import com.sopt.daisomall.core.designsystem.component.tag.DaisoNewTag
import com.sopt.daisomall.core.designsystem.component.tag.DaisoShippingTag
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme

@Composable
fun HomeRecommendCard(
    productName: String,
    productPrice: String,
    imageUrl: String,
    reviewCount: String,
    isLiked: Boolean,
    isNew: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(109.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        DaisoProductImage(
            imageUrl = imageUrl,
            width = 109.dp,
            height = 144.dp,
            onLikeClick = onLikeClick,
            isLiked = isLiked,
        )

        DaisoButton(
            type= ButtonType.GRAY_LINE,
            text = "담기",
            onClick = {},
            icon = R.drawable.ic_availablestores_20,
            modifier = Modifier.fillMaxWidth(),

        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "${productPrice}원",
                style = DaisoTheme.typography.body.b14,
                color = DaisoTheme.colors.gray10,
            )

            if (isNew) {
                DaisoNewTag()
            }
        }

        Text(
            text = productName,
            style = DaisoTheme.typography.body.m12,
            color = DaisoTheme.colors.gray10,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        DaisoShippingTag(text = "택배",)

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_stars_60),
                contentDescription = null,
                tint = DaisoTheme.colors.gray10,
                )

            Text(
                text = reviewCount,
                style = DaisoTheme.typography.caption.sb10,
                color = DaisoTheme.colors.gray10,
            )
        }
    }
}

@Preview
@Composable
private fun HomeRecommendCardPreview() {
    DaisoMallTheme { 
        HomeRecommendCard(
            productName = "[화잘먹/80매]마미케어 바다포도 스킨팩",
            productPrice = "5000",
            imageUrl = "",
            reviewCount = "70",
            isLiked = false,
            isNew = true,
            onLikeClick = {},
        )
    }
}

@Preview
@Composable
private fun HomeRecommendCardNotNewPreview() {
    DaisoMallTheme {
        HomeRecommendCard(
            productName = "[01라이트]본셉 비타씨에센스비비 30ml",
            productPrice = "5000",
            imageUrl = "",
            reviewCount = "70",
            isLiked = false,
            isNew = true,
            onLikeClick = {},
        )
    }
}

@Preview
@Composable
private fun HomeRecommendCardOneLinePreview() {
    DaisoMallTheme {
        HomeRecommendCard(
            productName = "[화잘먹/80매]마미케어",
            productPrice = "5000",
            imageUrl = "",
            reviewCount = "70",
            isLiked = false,
            isNew = true,
            onLikeClick = {},
        )
    }
}

@Preview
@Composable
private fun HomeRecommendCardPreviewOverFlow() {
    DaisoMallTheme {
        HomeRecommendCard(
            productName = "[화잘먹/80매]마미케어 바다포도 스킨팩 마미케어 바다포도 스킨팩",
            productPrice = "5000",
            imageUrl = "",
            reviewCount = "70",
            isLiked = false,
            isNew = true,
            onLikeClick = {},
        )
    }
}
