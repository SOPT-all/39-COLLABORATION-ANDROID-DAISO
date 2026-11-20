package com.sopt.daisomall.data.repository.impl

import com.sopt.daisomall.core.common.util.suspendRunCatching
import com.sopt.daisomall.data.datasource.api.ProductDataSource
import com.sopt.daisomall.data.mapper.toModel
import com.sopt.daisomall.data.repository.api.ProductRepository

class ProductRepositoryImpl(
    private val productDataSource: ProductDataSource,
) : ProductRepository {
    override suspend fun getProducts(keyword: String?) = suspendRunCatching {
        val data = productDataSource.getProducts(keyword).data
            ?: throw IllegalStateException("data is null")
        data.products.map { it.toModel() }
    }
}
