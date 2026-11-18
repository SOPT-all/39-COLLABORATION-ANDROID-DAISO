package com.sopt.daisomall.presentation.home

import androidx.lifecycle.ViewModel
import com.sopt.daisomall.presentation.home.model.dummyHomeProducts
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        loadProducts()
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

    private fun loadProducts() {
        val products = dummyHomeProducts

        _state.update { state ->
            state.copy(
                productList = products,
            )
        }
    }
}
