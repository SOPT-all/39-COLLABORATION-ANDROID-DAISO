package com.sopt.daisomall.presentation.search

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.sopt.daisomall.core.di.ServicePool
import com.sopt.daisomall.data.datasource.impl.ProductDataSourceImpl
import com.sopt.daisomall.data.mapper.toUiModel
import com.sopt.daisomall.data.repository.api.ProductRepository
import com.sopt.daisomall.data.repository.impl.ProductRepositoryImpl
import com.sopt.daisomall.presentation.search.model.dummyProducts
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
        loadProducts(searchTextFieldState.text.toString().trim())
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
                    _state.update {
                        it.copy(productList = products.map { p ->
                            p.toUiModel()
                        }.toImmutableList())
                    }
                }
                .onFailure { Timber.e(it) /* 또는 Log.e */ }
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                SearchViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    productRepository = ProductRepositoryImpl(
                        ProductDataSourceImpl(ServicePool.productService),
                    ),
                )
            }
        }
    }
}
