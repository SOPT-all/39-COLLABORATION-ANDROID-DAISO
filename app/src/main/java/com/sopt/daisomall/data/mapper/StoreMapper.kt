package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.ProductStoresResponseDto
import com.sopt.daisomall.data.dto.StoreProductDto
import com.sopt.daisomall.data.dto.StoreStockDto
import com.sopt.daisomall.data.model.ProductStoresModel
import com.sopt.daisomall.data.model.StoreProductModel
import com.sopt.daisomall.data.model.StoreStockModel

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
