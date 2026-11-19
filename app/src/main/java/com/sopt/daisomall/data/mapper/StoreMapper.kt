package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.ProductStoresResponseDto
import com.sopt.daisomall.data.dto.StoreProductDto
import com.sopt.daisomall.data.dto.StoreStockDto
import com.sopt.daisomall.data.model.ProductStoresModel
import com.sopt.daisomall.data.model.StoreProductModel
import com.sopt.daisomall.data.model.StoreStockModel
import com.sopt.daisomall.presentation.stockcheck.model.StockStoreModel
import com.sopt.daisomall.presentation.stockcheck.type.StockStatus

private const val BUSINESS_STATUS_OPEN = "OPEN"

fun ProductStoresResponseDto.toModel(): ProductStoresModel = ProductStoresModel(
    product = product.toModel(),
    stores = stores.map { it.toModel() },
)

fun StoreProductDto.toModel(): StoreProductModel = StoreProductModel(
    productId = productId,
    productNumber = productNumber,
    name = name,
    price = price,
    imageUrl = imageUrl,
)

fun StoreStockDto.toModel(): StoreStockModel = StoreStockModel(
    storeId = storeId,
    storeName = storeName,
    imageUrl = imageUrl,
    isOpen = businessStatus == BUSINESS_STATUS_OPEN,
    isBookmarked = bookmarked,
    distanceMeters = distanceMeters,
    distance = distance,
    stockQuantity = stockQuantity,
    isPickupAvailable = pickupAvailable,
)

fun StoreStockModel.toStockStoreModel(): StockStoreModel = StockStoreModel(
    storeId = storeId,
    storeName = storeName,
    distanceMeters = distanceMeters.toInt(),
    stockCount = stockQuantity,
    // TODO: 서버 응답에 층·번호 정보 없음
    floor = "",
    number = "",
    stockStatus = when {
        stockQuantity == 0 -> StockStatus.OUT_OF_STOCK
        isPickupAvailable -> StockStatus.PICKUP_AVAILABLE
        else -> StockStatus.PICKUP_CLOSED
    },
    imageUrl = imageUrl,
    isOpen = isOpen,
    isFavoriteStore = isBookmarked,
)
