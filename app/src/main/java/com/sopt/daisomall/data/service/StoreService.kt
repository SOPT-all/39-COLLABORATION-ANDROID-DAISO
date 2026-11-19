package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductStoresResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoreService {
    @GET("api/v1/products/{productId}/stores")
    suspend fun getProductStores(
        @Path("productId") productId: Long,
        @Query("soldOut") soldOut: Boolean,
    ): BaseResponse<ProductStoresResponseDto>
}
