package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("productId") val productId: Long,
    @SerialName("productNumber") val productNumber: String,
    @SerialName("name") val name: String,
    @SerialName("price") val price: String,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("reviewCount") val reviewCount: String,
    @SerialName("liked") val liked: Boolean,
)