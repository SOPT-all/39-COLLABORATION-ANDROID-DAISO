package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.ProductDto
import com.sopt.daisomall.data.model.ProductModel

fun ProductDto.toModel() = ProductModel(
    id = productId,
    productNumber = productNumber,
    name = name,
    price = price,
    imageUrl = imageUrl,
    reviewCount = reviewCount,
    isLiked = liked,
)
