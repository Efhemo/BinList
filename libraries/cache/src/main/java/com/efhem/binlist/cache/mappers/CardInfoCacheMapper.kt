package com.efhem.binlist.cache.mappers

import com.efhem.binlist.cache.model.CardInfoCacheModel
import com.efhem.binlist.cache.mappers.base.CacheModelMapper
import com.efhem.binlist.data.model.CardInfoEntity
import javax.inject.Inject

class CardInfoCacheMapper @Inject constructor(): CacheModelMapper<CardInfoCacheModel, CardInfoEntity> {

    override fun mapToModel(entity: CardInfoEntity): CardInfoCacheModel {
        return with(entity){
            CardInfoCacheModel(
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

    override fun mapToEntity(model: CardInfoCacheModel): CardInfoEntity {
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