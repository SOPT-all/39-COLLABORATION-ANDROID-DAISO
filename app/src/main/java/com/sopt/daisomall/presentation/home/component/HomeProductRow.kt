package com.sopt.daisomall.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.presentation.home.model.HomeProductUiModel
import com.sopt.daisomall.presentation.home.model.dummyHomeProduct
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun HomeProductRow(
    products: ImmutableList<HomeProductUiModel>,
    onLikeClick: (Long) -> Unit,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = paddingValues,
    ) {
        items(
            items = products,
            key = { product -> product.id }
        ) { product ->
            HomeRecommendCard(
                productName = product.name,
                productPrice = product.price,
                imageUrl = product.imageUrl,
                reviewCount = product.reviewCount,
                isLiked = product.isLiked,
                isNew = true,
                onLikeClick = { onLikeClick(product.id) },
            )

        }
    }
}

@Preview
@Composable
private fun HomeProductRowPreview() {
    DaisoMallTheme {
        HomeProductRow(
            products = dummyHomeProduct,
            onLikeClick = {},
            paddingValues = PaddingValues(horizontal = 20.dp)
        )
    }
}
