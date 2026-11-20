package com.sopt.daisomall.core.di

import com.sopt.daisomall.core.network.ApiFactory
import com.sopt.daisomall.data.service.ProductService
import com.sopt.daisomall.data.service.StoreBookmarkService
import com.sopt.daisomall.data.service.StoreService

/**
 * 수동 주입용 Service 모음
 *
 * Service를 추가할 때 아래처럼 선언해서 사용합니다.
 * val productService: ProductService by lazy { ApiFactory.create<ProductService>() }
 */
object ServicePool {
    val productService: ProductService by lazy { ApiFactory.create<ProductService>() }

    val storeService: StoreService by lazy { ApiFactory.create<StoreService>() }

    val storeBookmarkService: StoreBookmarkService by lazy {
        ApiFactory.create<StoreBookmarkService>()
    }
}
