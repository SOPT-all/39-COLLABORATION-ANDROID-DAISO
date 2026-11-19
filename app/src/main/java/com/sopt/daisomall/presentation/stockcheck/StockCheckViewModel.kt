package com.sopt.daisomall.presentation.stockcheck

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StockCheckViewModel : ViewModel() {
    private val _state = MutableStateFlow(StockCheckUiState())

    val state: StateFlow<StockCheckUiState> = _state.asStateFlow()

    fun onSoldOutChip(checked: Boolean) {
        _state.update { state ->
            state.copy(
                isSoldOutExcluded = checked,
            )
        }
    }

    fun onBookmarkClick(storeId: Long) {
        _state.update { state ->
            state.copy(
                stores = state.stores.map { store ->
                    if (store.storeId == storeId) {
                        store.copy(
                            isFavoriteStore = !store.isFavoriteStore,
                        )
                    } else {
                        store
                    }
                }.toImmutableList(),
            )
        }
    }

}
