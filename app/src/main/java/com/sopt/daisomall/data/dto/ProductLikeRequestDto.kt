package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductLikeRequestDto(
    @SerialName("liked")
    val liked: Boolean,
)