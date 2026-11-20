package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.StoreBookmarkDto
import com.sopt.daisomall.data.model.StoreBookmarkModel

fun StoreBookmarkDto.toModel(): StoreBookmarkModel = StoreBookmarkModel(
    storeId = storeId,
    favorite = favorite,
)