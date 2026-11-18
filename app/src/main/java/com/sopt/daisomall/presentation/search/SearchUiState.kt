package com.sopt.daisomall.presentation.search

import androidx.compose.runtime.Immutable
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class SearchUiState(
    val productList: ImmutableList<ProductUiModel> = persistentListOf(),
)
