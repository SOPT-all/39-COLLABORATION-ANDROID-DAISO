package com.sopt.daisomall.presentation.search

import androidx.compose.runtime.Immutable
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Immutable
data class SearchUiState(
    val searchedKeyword: String = "",
    val productList: ImmutableList<ProductUiModel> = persistentListOf(),
) {
    fun searchSucceeded(keyword: String, products: List<ProductUiModel>): SearchUiState =
        copy(
            searchedKeyword = keyword,
            productList = products.toImmutableList(),
        )

    fun toggleLike(productId: Long): SearchUiState =
        copy(
            productList = productList.map { product ->
                if (product.id == productId) product.copy(isLiked = !product.isLiked)
                else product
            }.toImmutableList()
        )
}
