package com.sopt.daisomall.data.repository.impl

import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.repository.api.ProductDataSource
import com.sopt.daisomall.data.service.ProductService

class ProductDataSourceImpl(
    private val productService: ProductService,
) : ProductDataSource {
    override suspend fun patchLike(
        productId: Long,
        request: ProductLikeRequestDto,
    ) = productService.patchLike(productId, request)
}