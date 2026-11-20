package com.sopt.daisomall.data.repository.impl

import com.sopt.daisomall.core.common.util.suspendRunCatching
import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.model.ProductLikeModel
import com.sopt.daisomall.data.repository.api.ProductDataSource
import com.sopt.daisomall.data.repository.api.ProductRepository

class ProductRepositoryImpl(
    private val productDatasource: ProductDataSource,
) : ProductRepository {
    override suspend fun patchLike(
        productId: Long,
        liked: Boolean,
    ) = suspendRunCatching {
        val data = productDatasource.patchLike(
    productId = productId,
    request = ProductLikeRequestDto(liked =liked),).data
            ?: throw IllegalStateException("data is null")
        data.toModel()
    }
}
