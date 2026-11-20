package com.sopt.daisomall.presentation.stockcheck

import androidx.compose.runtime.Immutable
import com.sopt.daisomall.data.model.StoreProductModel
import com.sopt.daisomall.presentation.stockcheck.model.StockStoreModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class StockCheckUiState(
    val product: StoreProductModel? = null,
    val stores: ImmutableList<StockStoreModel> = persistentListOf(),
    val isSoldOutExcluded: Boolean = true,
)
