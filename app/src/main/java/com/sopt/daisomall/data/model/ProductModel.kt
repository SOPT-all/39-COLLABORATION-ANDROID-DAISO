package com.sopt.daisomall.data.model

data class ProductModel(
    val id: Long,
    val productNumber: String,
    val name: String,
    val price: String,
    val imageUrl: String,
    val reviewCount: String,
    val isLiked: Boolean,
)
