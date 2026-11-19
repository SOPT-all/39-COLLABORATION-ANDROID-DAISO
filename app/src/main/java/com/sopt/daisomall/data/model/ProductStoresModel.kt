package com.sopt.daisomall.data.model

data class ProductStoresModel(
    val product: StoreProductModel,
    val stores: List<StoreStockModel>,
)

data class StoreProductModel(
    val productId: Long,
    val productNumber: String,
    val name: String,
    val price: String,
    val imageUrl: String,
)

data class StoreStockModel(
    val storeId: Long,
    val storeName: String,
    val imageUrl: String,
    val isOpen: Boolean,
    val isBookmarked: Boolean,
    val distanceMeters: Long,
    val distance: String,
    val stockQuantity: Int,
    val isPickupAvailable: Boolean,
)
