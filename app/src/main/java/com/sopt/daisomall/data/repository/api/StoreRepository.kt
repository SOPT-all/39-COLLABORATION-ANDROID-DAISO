package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.data.model.ProductStoresModel

interface StoreRepository {
    suspend fun getProductStores(
        productId: Long,
        soldOut: Boolean,
    ): Result<ProductStoresModel>
}
