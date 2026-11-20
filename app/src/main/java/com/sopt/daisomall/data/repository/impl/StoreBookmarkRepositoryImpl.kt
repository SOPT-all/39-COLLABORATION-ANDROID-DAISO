package com.sopt.daisomall.data.repository.impl

import com.sopt.daisomall.core.common.util.suspendRunCatching
import com.sopt.daisomall.data.datasource.api.StockBookmarkDatasource
import com.sopt.daisomall.data.model.StoreBookmarkModel
import com.sopt.daisomall.data.repository.api.StoreBookmarkRepository
import com.sopt.daisomall.data.mapper.toModel

class StoreBookmarkRepositoryImpl (

    private val storeBookmarkDatasource : StockBookmarkDatasource,
): StoreBookmarkRepository {
    override suspend fun patchStoreBookmarks(
        storeId : Long,
        favorite : Boolean,
    ): Result<StoreBookmarkModel> = suspendRunCatching {
        val response = storeBookmarkDatasource.patchStoreBookmarks(
            storeId = storeId,
        )
        requireNotNull(response.data) {response.message}.toModel()
    }
}