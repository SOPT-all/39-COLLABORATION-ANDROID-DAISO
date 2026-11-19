package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductStoresResponseDto(
    @SerialName("productId")
    val productId: Long,
    @SerialName("product")
    val product: StoreProductDto,
    @SerialName("stores")
    val stores: List<StoreStockDto>,
)

@Serializable
data class StoreProductDto(
    @SerialName("productId")
    val productId: Long,
    @SerialName("productNumber")
    val productNumber: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("reviewCount")
    val reviewCount: String,
    @SerialName("liked")
    val liked: Boolean,
)

@Serializable
data class StoreStockDto(
    @SerialName("storeId")
    val storeId: Long,
    @SerialName("storeName")
    val storeName: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("businessStatus")
    val businessStatus: String,
    @SerialName("bookmarked")
    val bookmarked: Boolean,
    @SerialName("distanceMeters")
    val distanceMeters: Long,
    @SerialName("distance")
    val distance: String,
    @SerialName("stockQuantity")
    val stockQuantity: Int,
    @SerialName("pickupAvailable")
    val pickupAvailable: Boolean,
)
