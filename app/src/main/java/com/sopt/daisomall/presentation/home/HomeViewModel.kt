package com.sopt.daisomall.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.daisomall.core.di.RepositoryPool.productRepository
import com.sopt.daisomall.data.mapper.toHomeProductUiModel
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

    // keyword 없이 요청하면 서버가 추천순으로 내려줌
    private fun loadProducts() {
        viewModelScope.launch {
            productRepository.getProducts(keyword = null)
                .onSuccess { products ->
                    _state.update { state ->
                        state.copy(
                            productList = products.map { it.toHomeProductUiModel() }.toImmutableList(),
                        )
                    }
                }
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
