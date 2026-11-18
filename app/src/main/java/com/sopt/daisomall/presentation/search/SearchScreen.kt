package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.daisomall.core.designsystem.theme.DaisoMallTheme
import com.sopt.daisomall.core.designsystem.theme.DaisoTheme
import com.sopt.daisomall.presentation.search.component.SearchResultList
import com.sopt.daisomall.presentation.search.component.SearchTextFieldTopBar
import com.sopt.daisomall.presentation.search.model.dummyProducts
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SearchRoute(
    navigateBack: () -> Unit,
    navigateToStockCheck: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SearchScreen(
        state = state,
        searchTextFieldState = viewModel.searchTextFieldState,
        onSearch = viewModel::search,
        onLikeClick = viewModel::onLikeClick,
        onBackClick = navigateBack,
        onFindClick = navigateToStockCheck,
        modifier = modifier,
    )
}

@Composable
private fun SearchScreen(
    state: SearchUiState,
    searchTextFieldState: TextFieldState,
    onSearch: () -> Unit,
    onLikeClick: (Long) -> Unit,
    onBackClick: () -> Unit,
    onFindClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DaisoTheme.colors.white),
    ) {
        SearchTextFieldTopBar(
            state = searchTextFieldState,
            onBackClick = onBackClick,
            onSearch = onSearch,
        )

        SearchResultList(
            products = state.productList,
            onLikeClick = onLikeClick,
            onFindClick = onFindClick,
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    DaisoMallTheme {
        SearchScreen(
            state = SearchUiState(
                searchedKeyword = "마스크",
                productList = dummyProducts.toImmutableList(),
            ),
            searchTextFieldState = rememberTextFieldState(initialText = "마스크"),
            onSearch = {},
            onLikeClick = {},
            onBackClick = {},
            onFindClick = {},
        )
    }
}
