package com.efhem.binlist.cache.mappers

import com.efhem.binlist.cache.entity.CardInfoCache
import com.efhem.binlist.cache.mappers.base.CacheModelMapper
import com.efhem.binlist.data.model.CardInfoEntity
import javax.inject.Inject

class CardInfoCacheMapper @Inject constructor(): CacheModelMapper<CardInfoCache, CardInfoEntity> {

    override fun mapToModel(entity: CardInfoEntity): CardInfoCache {
        return with(entity){
            CardInfoCache(
                cardNumber,
                city,
                bankName,
                phone,
                url,
                brand,
                alpha2,
                currency,
                emoji,
                latitude,
                longitude,
                countryName,
                numeric,
                length,
                luhn,
                prepaid,
                scheme,
                type)
        }
    }

    override fun mapToEntity(model: CardInfoCache): CardInfoEntity {
        return with(model){
            CardInfoEntity(cardNumber,
                city,
                bankName,
                phone,
                url,
                brand,
                alpha2,
                currency,
                emoji,
                latitude,
                longitude,
                countryName,
                numeric,
                length,
                luhn,
                prepaid,
                scheme,
                type)
        }
    }
}