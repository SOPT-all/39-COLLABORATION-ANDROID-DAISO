package com.sopt.daisomall.presentation.stockcheck

import androidx.compose.runtime.Immutable
import com.sopt.daisomall.presentation.stockcheck.model.CardStockDummy
import com.sopt.daisomall.presentation.stockcheck.model.StockStoreModel
import kotlinx.collections.immutable.ImmutableList
@Immutable
data class StockCheckUiState(
    val stores: ImmutableList<StockStoreModel> = CardStockDummy,
    val isSoldOutExcluded: Boolean = true,
)