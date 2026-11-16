package com.sopt.daisomall.presentation.search

import androidx.lifecycle.ViewModel
import com.sopt.daisomall.presentation.search.model.ProductUiModel
import com.sopt.daisomall.presentation.search.model.dummyProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {
    private val _products = MutableStateFlow(dummyProducts)
    val products: StateFlow<List<ProductUiModel>> = _products.asStateFlow()
}
