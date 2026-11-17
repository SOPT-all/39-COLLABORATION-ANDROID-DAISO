package com.sopt.daisomall.presentation.stockcheck.model

import com.sopt.daisomall.presentation.stockcheck.type.StockStatus

data class StockStoreModel(
    val storeId: Long,
    val storeName: String,
    val distanceMeters: Int,
    val stockCount: Int,
    val floor: String,
    val number: String,
    val stockStatus: StockStatus,
    val imageUrl : String,
    val isOpen : Boolean,
    val isFavoriteStore : Boolean,
)