package com.sopt.daisomall.core.di

import com.sopt.daisomall.data.datasource.impl.ProductDataSourceImpl
import com.sopt.daisomall.data.repository.api.ProductRepository
import com.sopt.daisomall.data.repository.impl.ProductRepositoryImpl

/**
 * 수동 주입용 Repository 모음
 */
object RepositoryPool {
    val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(
            productDataSource = ProductDataSourceImpl(ServicePool.productService),
        )
    }
}
