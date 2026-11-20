package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.ProductLikeResponseDto
import com.sopt.daisomall.data.model.ProductLikeModel

fun ProductLikeResponseDto.toModel() = ProductLikeModel(
    id = productId,
    isLiked = liked,
)