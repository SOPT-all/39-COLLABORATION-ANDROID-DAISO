package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.dto.ProductLikeResponseDto
import retrofit2.http.Body
import retrofit2.http.PATCH
import retrofit2.http.Path

interface ProductService {
    @PATCH("/api/v1/products/{productId}/like")
    suspend fun patchLike(
        @Path("productId") productId: Long,
        @Body request: ProductLikeRequestDto,
    ): BaseResponse<ProductLikeResponseDto>
}
