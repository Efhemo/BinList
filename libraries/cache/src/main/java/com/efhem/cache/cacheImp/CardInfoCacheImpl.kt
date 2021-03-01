package com.efhem.cache.cacheImp

import com.efhem.cache.mappers.CardInfoCacheMapper
import com.efhem.cache.room.CardInfoDao
import com.efhem.data.contract.cache.CardInfoRepository
import com.efhem.data.model.CardInfoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CardInfoCacheImpl @Inject constructor (
    private val cardInfoDao: CardInfoDao,
    private val cardInfoCacheMapper: CardInfoCacheMapper
): CardInfoRepository {

    override suspend fun saveCardInfo(cardInfoEntity: CardInfoEntity) {
        cardInfoDao.insertCardInfo(cardInfoCacheMapper.mapToModel(cardInfoEntity))
    }

    override fun getCardInfoSearches(): Flow<List<CardInfoEntity>> {
        return cardInfoDao.searches().map {
            cardInfoCacheMapper.mapToEntityList(it)
        }
    }
}