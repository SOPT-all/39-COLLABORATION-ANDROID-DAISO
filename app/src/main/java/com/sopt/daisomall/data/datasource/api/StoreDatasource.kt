package com.sopt.daisomall.data.datasource.api

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductStoresResponseDto

interface StoreDatasource {
    suspend fun getProductStores(
        productId: Long,
        soldOut: Boolean,
    ): BaseResponse<ProductStoresResponseDto>
}
