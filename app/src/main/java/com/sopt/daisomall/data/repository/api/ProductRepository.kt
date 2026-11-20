package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.data.model.ProductLikeModel
import com.sopt.daisomall.data.model.ProductModel

interface ProductRepository {
    suspend fun getProducts(
        keyword: String?
    ): Result<List<ProductModel>>

    suspend fun patchLike(
        productId: Long,
        liked: Boolean,
    ): Result<ProductLikeModel>
}
