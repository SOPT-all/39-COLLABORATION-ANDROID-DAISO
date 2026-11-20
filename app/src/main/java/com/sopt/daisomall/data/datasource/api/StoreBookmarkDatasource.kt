package com.sopt.daisomall.data.datasource.api

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.StoreBookmarkDto
import com.sopt.daisomall.data.dto.StoreBookmarkRequestDto

interface StockBookmarkDatasource {
    suspend fun patchStoreBookmarks(
        storeId : Long,
        request: StoreBookmarkRequestDto,
    ): BaseResponse<StoreBookmarkDto>
}
