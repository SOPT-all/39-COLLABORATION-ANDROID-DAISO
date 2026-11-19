package com.sopt.daisomall.data.mapper

import com.sopt.daisomall.data.dto.ProductDto
import com.sopt.daisomall.data.model.ProductModel
import com.sopt.daisomall.presentation.search.model.ProductUiModel

fun ProductDto.toModel() = ProductModel(
    id = productId,
    productNumber = productNumber,
    name = name,
    price = price,
    imageUrl = imageUrl,
    reviewCount = reviewCount,
    isLiked = liked,
)

fun ProductModel.toUiModel(): ProductUiModel = ProductUiModel(
    id = id,
    productNumber = productNumber,
    name = name,
    price = price,
    imageUrl = imageUrl,
    reviewCount = reviewCount,
    isLiked = isLiked,
)
