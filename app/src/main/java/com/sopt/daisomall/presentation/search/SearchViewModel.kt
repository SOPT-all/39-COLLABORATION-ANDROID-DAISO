package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.sopt.daisomall.presentation.search.model.dummyProducts
import com.sopt.daisomall.presentation.search.navigation.Search
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val initialKeyword: String = savedStateHandle.toRoute<Search>().keyword

    val searchTextFieldState = TextFieldState(initialText = initialKeyword)

    private val _state = MutableStateFlow(SearchUiState())
    val state: StateFlow<SearchUiState> = _state.asStateFlow()

    init {
        loadProducts(initialKeyword)
    }

    fun search() {
        loadProducts(searchTextFieldState.text.toString().trim())
    }

    fun onLikeClick(productId: Long) {
        _state.update { it.toggleLike(productId) }
    }

    // TODO: API 연결 시 서버 검색 결과로 교체
    private fun loadProducts(keyword: String) {
        val products = if (keyword.isEmpty()) {
            dummyProducts
        } else {
            dummyProducts.filter { it.name.contains(keyword) || it.productNumber.contains(keyword) }
        }
        _state.update { it.searchSucceeded(keyword, products) }
    }
}
