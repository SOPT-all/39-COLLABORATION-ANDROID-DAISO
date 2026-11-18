package com.sopt.daisomall.presentation.home.model

data class HomeProductUiModel(
    val id: Long,
    val name: String,
    val price: String,
    val imageUrl: String,
    val reviewCount: String,
    val isLiked: Boolean,
)