package com.sopt.daisomall.data.datasource.api

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.dto.ProductLikeResponseDto
import com.sopt.daisomall.data.dto.ProductListResponseDto

interface ProductDataSource {
    suspend fun getProducts(
        keyword: String?
    ): BaseResponse<ProductListResponseDto>

    suspend fun patchLike(
        productId: Long,
        request: ProductLikeRequestDto,
    ): BaseResponse<ProductLikeResponseDto>
}
