package com.efhem.binlist.cache.cacheImp

import com.efhem.binlist.cache.mappers.CardInfoCacheMapper
import com.efhem.binlist.cache.room.CardInfoDao
import com.efhem.binlist.data.contract.cache.CardInfoCacheRepository
import com.efhem.binlist.data.model.CardInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CardInfoCacheImpl @Inject constructor (
    private val cardInfoDao: CardInfoDao,
    private val cardInfoCacheMapper: CardInfoCacheMapper
): CardInfoCacheRepository {

    override suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity) {
        cardInfoDao.insertCardInfo(cardInfoCacheMapper.mapToModel(cardInfoEntity))
    }

    override fun getCardInfoSearches(): Flow<List<CardInfoEntity>> {
        return cardInfoDao.searches().map {
            cardInfoCacheMapper.mapToEntityList(it)
        }
    }
}