package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductLikeResponseDto(
    @SerialName("productId")
    val productId: Long,
    @SerialName("liked")
    val liked: Boolean,
)
