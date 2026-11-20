package com.sopt.daisomall.data.repository.impl

import com.sopt.daisomall.core.common.util.suspendRunCatching
import com.sopt.daisomall.data.datasource.api.StoreDatasource
import com.sopt.daisomall.data.mapper.toModel
import com.sopt.daisomall.data.model.ProductStoresModel
import com.sopt.daisomall.data.repository.api.StoreRepository

class StoreRepositoryImpl(
    private val storeDatasource: StoreDatasource,
) : StoreRepository {
    override suspend fun getProductStores(
        productId: Long,
        soldOut: Boolean,
    ): Result<ProductStoresModel> = suspendRunCatching {
        val response = storeDatasource.getProductStores(
            productId = productId,
            soldOut = soldOut,
        )
        requireNotNull(response.data) { response.message }.toModel()
    }
}
