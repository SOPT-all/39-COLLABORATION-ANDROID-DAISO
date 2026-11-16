package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.daisomall.core.common.util.suspendRunCatching
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import com.sopt.daisomall.presentation.search.model.dummyProducts
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val initialKeyword: String = savedStateHandle.get<String>(KEY_KEYWORD).orEmpty()

    val searchTextFieldState = TextFieldState(initialText = initialKeyword)

    private val _state = MutableStateFlow(SearchContract.State())
    val state: StateFlow<SearchContract.State> = _state.asStateFlow()

    private var searchJob: Job? = null

    init {
        loadProducts(initialKeyword)
    }

    fun search() {
        val keyword = searchTextFieldState.text.toString().trim()
        if (keyword.isEmpty()) return

        loadProducts(keyword)
    }

    private fun loadProducts(keyword: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            suspendRunCatching { fetchProducts(keyword) }
                .onSuccess { products -> _state.update { it.searchSucceeded(keyword, products) } }
                .onFailure { _state.update { it.searchFailed() } }
        }
    }

    // TODO: API 연결 시 repository 호출로 교체
    private suspend fun fetchProducts(keyword: String): List<ProductUiModel> {
        delay(500)
        return if (keyword.isEmpty()) {
            dummyProducts
        } else {
            dummyProducts.filter { it.name.contains(keyword) || it.productNumber.contains(keyword) }
        }
    }

    private companion object {
        const val KEY_KEYWORD = "keyword"
    }
}
