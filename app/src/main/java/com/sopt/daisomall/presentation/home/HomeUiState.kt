package com.sopt.daisomall.presentation.home

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState(
    val productList: ImmutableList<HomeProductUiModel> = persistentListOf(),
)