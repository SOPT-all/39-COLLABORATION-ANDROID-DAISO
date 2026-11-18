package com.sopt.daisomall.presentation.search.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun SearchResultList(
    products: ImmutableList<ProductUiModel>,
    onLikeClick: (Long) -> Unit,
    onFindClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
    ) {
        item {
            SearchFilterRow(
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
            )
        }

        item {
            SearchSortRow()
        }

        itemsIndexed(
            items = products,
            key = { _, product -> product.id }
        ) { index, product ->
            ProductCard(
                productNumber = product.productNumber,
                productName = product.name,
                price = product.price,
                imageUrl = product.imageUrl,
                reviewCount = product.reviewCount,
                isLiked = product.isLiked,
                onLikeClick = { onLikeClick(product.id) },
                onFindClick = { onFindClick(product.id) },
                modifier = Modifier.padding(20.dp),
            )
            if (index != products.lastIndex) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = DaisoTheme.colors.gray1
                )
            }
        }
    }
}