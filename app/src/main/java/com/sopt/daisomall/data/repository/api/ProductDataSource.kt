package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.dto.ProductLikeResponseDto

interface ProductDataSource {
    suspend fun patchLike(
        productId: Long,
        request: ProductLikeRequestDto,
    ): BaseResponse<ProductLikeResponseDto>
}
