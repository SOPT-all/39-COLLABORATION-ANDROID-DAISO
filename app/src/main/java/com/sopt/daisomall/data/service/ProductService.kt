package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductListResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("api/v1/products")
    suspend fun getProducts(
        @Query("keyword") keyword: String? = null,
    ): BaseResponse<ProductListResponseDto>
}