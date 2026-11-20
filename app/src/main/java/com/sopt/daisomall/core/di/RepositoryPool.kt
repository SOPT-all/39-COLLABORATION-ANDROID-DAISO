package com.sopt.daisomall.core.di

import com.sopt.daisomall.data.repository.api.ProductRepository
import com.sopt.daisomall.data.datasource.impl.ProductDataSourceImpl
import com.sopt.daisomall.data.repository.impl.ProductRepositoryImpl

object RepositoryPool {
    val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(
            productDatasource = ProductDataSourceImpl(
                ServicePool.productService
            )
        )
    }
}