package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sopt.daisomall.presentation.search.model.dummyProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val initialKeyword: String = savedStateHandle.get<String>(KEY_KEYWORD).orEmpty()

    val searchTextFieldState = TextFieldState(initialText = initialKeyword)

    private val _state = MutableStateFlow(SearchContract.State())
    val state: StateFlow<SearchContract.State> = _state.asStateFlow()

    init {
        loadProducts(initialKeyword)
    }

    fun search() {
        val keyword = searchTextFieldState.text.toString().trim()
        if (keyword.isEmpty()) return

        loadProducts(keyword)
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

    private companion object {
        const val KEY_KEYWORD = "keyword"
    }
}
