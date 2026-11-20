package com.sopt.daisomall.data.service

import com.sopt.daisomall.core.network.BaseResponse
import com.sopt.daisomall.data.dto.StoreBookmarkDto
import retrofit2.http.PATCH
import retrofit2.http.Path

interface StoreBookmarkService {
    @PATCH("/api/v1/stores/{storeId}/favorite")
    suspend fun patchStoreBookmarks(
        @Path("storeId") storeId : Long
    ): BaseResponse<StoreBookmarkDto>
}