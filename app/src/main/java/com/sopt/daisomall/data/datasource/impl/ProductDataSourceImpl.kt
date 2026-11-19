package com.sopt.daisomall.data.datasource.impl

import com.sopt.daisomall.data.datasource.api.ProductDataSource
import com.sopt.daisomall.data.service.ProductService

class ProductDataSourceImpl(
    private val productService: ProductService,
) : ProductDataSource {
    override suspend fun getProducts(
        keyword: String?
    ) = productService.getProducts(keyword)
}
