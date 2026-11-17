package com.sopt.daisomall.presentation.stockcheck.model

import com.sopt.daisomall.presentation.stockcheck.type.StockStatus
import java.math.BigInteger

data class StockStoreModel(
    val storeId: BigInteger,
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