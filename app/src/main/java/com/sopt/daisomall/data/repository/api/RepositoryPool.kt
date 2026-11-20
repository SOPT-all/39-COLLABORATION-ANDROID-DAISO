package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.data.repository.impl.ProductDataSourceImpl
import com.sopt.daisomall.data.repository.impl.ProductRepositoryImpl
import com.sopt.daisomall.data.service.ServicePool

object RepositoryPool {
    val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(
            productDatasource = ProductDataSourceImpl(
                ServicePool.productService
            )
        )
    }
}