package com.efhem.binlist.data.contract.cache

import com.efhem.binlist.data.model.CardInfoEntity
import kotlinx.coroutines.flow.Flow

interface CardInfoCacheRepository {

    suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity)

    fun getCardInfoSearches(): Flow<List<CardInfoEntity>>
}