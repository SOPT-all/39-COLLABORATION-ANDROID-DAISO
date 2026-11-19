package com.sopt.daisomall.presentation.stockcheck.model

import com.sopt.daisomall.presentation.stockcheck.type.StockStatus
import kotlinx.collections.immutable.persistentListOf

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

val CardStockDummy = persistentListOf(
    StockStoreModel(
        storeId = 12345,
        storeName = "구로디지털단지역점",
        distanceMeters = 300,
        stockCount = 56,
        floor = "2F",
        number = "2번",
        imageUrl = "",
        isOpen = true,
        stockStatus = StockStatus.PICKUP_AVAILABLE,
        isFavoriteStore = true,
    ),
    StockStoreModel(
        storeId = 23456,
        storeName = "모앱1조최고지역점",
        distanceMeters = 500,
        stockCount = 56,
        floor = "1F",
        number = "3번",
        imageUrl = "",
        isOpen = false,
        stockStatus = StockStatus.PICKUP_CLOSED,
        isFavoriteStore = false,
    ),
    StockStoreModel(
        storeId = 34567,
        storeName = "합세최강가만안드맞점",
        distanceMeters = 800,
        stockCount = 0,
        floor = "",
        number = "",
        imageUrl = "",
        isOpen = false,
        stockStatus = StockStatus.OUT_OF_STOCK,
        isFavoriteStore = false,
    ),
)