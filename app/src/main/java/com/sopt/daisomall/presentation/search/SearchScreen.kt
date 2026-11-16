package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.search.component.ProductCard
import com.sopt.daisomall.presentation.search.component.SearchFilterRow
import com.sopt.daisomall.presentation.search.component.SearchSortRow
import com.sopt.daisomall.presentation.search.component.SearchTextFieldTopBar
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import com.sopt.daisomall.presentation.search.model.dummyProducts
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SearchScreen(
        state = state,
        searchTextFieldState = viewModel.searchTextFieldState,
        onSearch = viewModel::search,
        modifier = modifier,
    )
}

@Composable
private fun SearchScreen(
    state: SearchContract.State,
    searchTextFieldState: TextFieldState,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DaisoTheme.colors.white),
    ) {
        SearchTextFieldTopBar(
            state = searchTextFieldState,
            onBackClick = {},
            onSearch = onSearch,
        )

        SearchResultList(
            products = state.productList,
            modifier = Modifier.weight(1f),
        )
    }
}

@Composable
private fun SearchResultList(
    products: ImmutableList<ProductUiModel>,
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
                onLikeClick = {},
                onFindClick = {},
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

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    DaisoMallTheme {
        SearchScreen(
            state = SearchContract.State(
                searchedKeyword = "마스크",
                productList = dummyProducts.toImmutableList(),
            ),
            searchTextFieldState = rememberTextFieldState(initialText = "마스크"),
            onSearch = {},
        )
    }
}
