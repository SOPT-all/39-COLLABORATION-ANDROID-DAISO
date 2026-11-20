package com.sopt.daisomall.data.repository.api

import com.sopt.daisomall.data.model.StoreBookmarkModel

interface StoreBookmarkRepository {
    suspend fun patchStoreBookmarks(
        storeId: Long,
        favorite: Boolean,
    ): Result<StoreBookmarkModel>
}