package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.model.ProductLikeModel

interface ProductRepository {
    suspend fun patchLike(
        productId: Long,
        liked: Boolean,
    ): Result<ProductLikeModel>
}
