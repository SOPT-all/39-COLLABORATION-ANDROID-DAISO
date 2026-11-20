package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.ApiFactory
import kotlin.lazy

object ServicePool {
    val productService: ProductService by lazy {
        ApiFactory.create<ProductService>()
    }
}