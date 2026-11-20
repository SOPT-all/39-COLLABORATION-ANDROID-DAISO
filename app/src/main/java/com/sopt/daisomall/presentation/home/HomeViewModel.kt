package com.sopt.daisomall.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.daisomall.core.di.RepositoryPool.productRepository
import com.sopt.daisomall.presentation.home.model.dummyHomeProducts
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        val products = dummyHomeProducts

        _state.update { state ->
            state.copy(
                productList = products,
            )
        }
    }

    fun onLikeClick(productId: Long) {
        val product = _state.value.productList
            .find { it.id == productId } ?: return

        viewModelScope.launch {
            productRepository.patchLike(
                productId = productId,
                liked = !product.isLiked,
            )
                .onSuccess { result ->
                    _state.update { state ->
                        state.copy(
                            productList = state.productList.map {
                                if (it.id == productId) {
                                    it.copy(isLiked = result.isLiked)
                                } else {
                                    it
                                }
                            }.toImmutableList()
                        )
                    }
                }
        }
    }

}
