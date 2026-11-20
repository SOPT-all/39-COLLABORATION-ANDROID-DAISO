package com.sopt.daisomall.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreBookmarkDto(

    @SerialName("storeId")
    val storeId : Long,
    @SerialName("favorite")
    val favorite : Boolean,
    )