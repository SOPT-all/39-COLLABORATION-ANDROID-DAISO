package com.sopt.daisomall.presentation.search.model

data class ProductUiModel(
    val id: Long,
    val productNumber: String,
    val name: String,
    val price: String,
    val imageUrl: String,
    val reviewCount: String,
    val isLiked: Boolean,
)
