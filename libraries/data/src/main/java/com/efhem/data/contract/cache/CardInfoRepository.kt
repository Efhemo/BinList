package com.efhem.data.contract.cache

import com.efhem.data.model.CardInfoEntity
import kotlinx.coroutines.flow.Flow

interface CardInfoRepository {

    suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity)

    fun getCardInfoSearches(): Flow<List<CardInfoEntity>>
}