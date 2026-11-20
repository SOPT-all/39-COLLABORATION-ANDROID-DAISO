package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreBookmarkRequestDto(
    @SerialName("favorite")
    val favorite: Boolean,
)
