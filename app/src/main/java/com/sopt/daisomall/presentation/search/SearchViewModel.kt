package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.sopt.daisomall.core.di.RepositoryPool
import com.sopt.daisomall.data.mapper.toUiModel
import com.sopt.daisomall.data.repository.api.ProductRepository
import com.sopt.daisomall.presentation.search.navigation.Search
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel(
    savedStateHandle: SavedStateHandle,
    private val productRepository: ProductRepository,
) : ViewModel() {

    private val initialKeyword: String = savedStateHandle.toRoute<Search>().keyword

    val searchTextFieldState = TextFieldState(initialText = initialKeyword)

    private val _state = MutableStateFlow(SearchUiState())
    val state: StateFlow<SearchUiState> = _state.asStateFlow()

    init {
        loadProducts(initialKeyword)
    }

    fun search() {
        val keyword = searchTextFieldState.text.toString().trim()
        if (keyword.isEmpty()) return
        loadProducts(keyword)
    }

    fun onLikeClick(productId: Long) {
        _state.update { state ->
            state.copy(
                productList = state.productList.map { product ->
                    if (product.id == productId) {
                        product.copy(isLiked = !product.isLiked)
                    } else {
                        product
                    }
                }.toImmutableList()
            )
        }
    }

    private fun loadProducts(keyword: String) {
        viewModelScope.launch {
            productRepository.getProducts(keyword.ifBlank { null })
                .onSuccess { products ->
                    _state.update { state ->
                        state.copy(productList = products.map {
                            it.toUiModel()
                        }.toImmutableList())
                    }
                }
                .onFailure { Timber.e(it) }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                SearchViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    productRepository = RepositoryPool.productRepository,
                )
            }
        }
    }
}
