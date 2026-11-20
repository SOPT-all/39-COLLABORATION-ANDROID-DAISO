package com.sopt.daisomall.presentation.stockcheck

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.sopt.daisomall.core.di.RepositoryPool
import com.sopt.daisomall.data.repository.api.StoreBookmarkRepository
import com.sopt.daisomall.data.repository.api.StoreRepository
import com.sopt.daisomall.data.mapper.toStockStoreModel
import com.sopt.daisomall.presentation.stockcheck.navigation.StockCheck
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StockCheckViewModel(
    savedStateHandle: SavedStateHandle,
    private val storeRepository: StoreRepository,
    private val storeBookmarkRepository: StoreBookmarkRepository,
) : ViewModel() {
    private val productId: Long = savedStateHandle.toRoute<StockCheck>().productId

    private val _state = MutableStateFlow(StockCheckUiState())

    val state: StateFlow<StockCheckUiState> = _state.asStateFlow()

    init {
        loadStores()
    }

    fun onSoldOutChip(checked: Boolean) {
        _state.update { state ->
            state.copy(
                isSoldOutExcluded = checked,
            )
        }
        loadStores()
    }

    fun onBookmarkClick(storeId: Long) {
        val store = _state.value.stores.find { it.storeId == storeId } ?: return
        val favorite = !store.isFavoriteStore

        updateBookmark(storeId = storeId, favorite = favorite)

        viewModelScope.launch {
            storeBookmarkRepository.patchStoreBookmarks(
                storeId = storeId,
                favorite = favorite,
            ).onFailure {
                updateBookmark(storeId = storeId, favorite = !favorite)
            }
        }
    }

    private fun updateBookmark(storeId: Long, favorite: Boolean) {
        _state.update { state ->
            state.copy(
                stores = state.stores.map { store ->
                    if (store.storeId == storeId) {
                        store.copy(
                            isFavoriteStore = favorite,
                        )
                    } else {
                        store
                    }
                }.toImmutableList(),
            )
        }
    }

    private fun loadStores() {
        viewModelScope.launch {
            storeRepository.getProductStores(
                productId = productId,
                soldOut = _state.value.isSoldOutExcluded,
            ).onSuccess { productStores ->
                _state.update { state ->
                    state.copy(
                        product = productStores.product,
                        stores = productStores.stores.map { it.toStockStoreModel() }.toImmutableList(),
                    )
                }
            }.onFailure {
                // TODO: 에러 처리
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                StockCheckViewModel(
                    savedStateHandle = createSavedStateHandle(),
                    storeRepository = RepositoryPool.storeRepository,
                    storeBookmarkRepository = RepositoryPool.storeBookmarkRepository,
                )
            }
        }
    }
}
