package com.sopt.daisomall.core.di

import com.sopt.daisomall.data.datasource.impl.StoreDatasourceImpl
import com.sopt.daisomall.data.repository.api.StoreRepository
import com.sopt.daisomall.data.repository.impl.StoreRepositoryImpl

/**
 * 수동 주입용 Repository 모음
 */
object RepositoryPool {
    val storeRepository: StoreRepository by lazy {
        StoreRepositoryImpl(
            storeDatasource = StoreDatasourceImpl(ServicePool.storeService),
        )
    }
}
