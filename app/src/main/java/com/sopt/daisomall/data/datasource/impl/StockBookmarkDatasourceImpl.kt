package com.sopt.daisomall.data.datasource.impl

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.StoreBookmarkDto
import com.sopt.daisomall.data.dto.StoreBookmarkRequestDto
import com.sopt.daisomall.data.datasource.api.StockBookmarkDatasource
import com.sopt.daisomall.data.service.StoreBookmarkService

class StockBookmarkDatasourceImpl(
    private val stockBookmarkService : StoreBookmarkService,
) : StockBookmarkDatasource {
    override suspend fun patchStoreBookmarks(
        storeId: Long,
        request: StoreBookmarkRequestDto,
    ): BaseResponse<StoreBookmarkDto> =
        stockBookmarkService.patchStoreBookmarks(storeId = storeId, request = request)
}
