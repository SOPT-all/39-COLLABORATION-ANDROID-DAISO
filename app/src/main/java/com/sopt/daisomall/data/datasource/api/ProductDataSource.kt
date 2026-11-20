package com.sopt.daisomall.data.datasource.api

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.ProductListResponseDto

interface ProductDataSource {
    suspend fun getProducts(
        keyword: String?
    ): BaseResponse<ProductListResponseDto>
}
