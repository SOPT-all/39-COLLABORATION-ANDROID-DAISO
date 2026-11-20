package com.sopt.daisomall.data.datasource.impl

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.datasource.api.StoreDatasource
import com.sopt.daisomall.data.dto.ProductStoresResponseDto
import com.sopt.daisomall.data.service.StoreService

class StoreDatasourceImpl(
    private val storeService: StoreService,
) : StoreDatasource {
    override suspend fun getProductStores(
        productId: Long,
        soldOut: Boolean,
    ): BaseResponse<ProductStoresResponseDto> =
        storeService.getProductStores(
            productId = productId,
            soldOut = soldOut,
        )
}
