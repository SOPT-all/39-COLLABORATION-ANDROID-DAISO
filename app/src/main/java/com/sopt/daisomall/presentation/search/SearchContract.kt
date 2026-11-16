package com.sopt.daisomall.presentation.search

import androidx.compose.runtime.Immutable
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

sealed interface SearchContract {
    @Immutable
    data class State(
        val searchedKeyword: String = "",
        val productList: ImmutableList<ProductUiModel> = persistentListOf(),
    ) {
        fun searchSucceeded(keyword: String, products: List<ProductUiModel>): State =
            copy(
                searchedKeyword = keyword,
                productList = products.toImmutableList(),
            )

        fun searchFailed(): State =
            copy(productList = persistentListOf())
    }
}
