package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductLikeRequestDto
import com.sopt.daisomall.data.dto.ProductLikeResponseDto
import com.sopt.daisomall.data.dto.ProductListResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {
    @GET("api/v1/products")
    suspend fun getProducts(
        @Query("keyword") keyword: String? = null,
    ): BaseResponse<ProductListResponseDto>

    @PATCH("/api/v1/products/{productId}/like")
    suspend fun patchLike(
        @Path("productId") productId: Long,
        @Body request: ProductLikeRequestDto,
    ): BaseResponse<ProductLikeResponseDto>
}
