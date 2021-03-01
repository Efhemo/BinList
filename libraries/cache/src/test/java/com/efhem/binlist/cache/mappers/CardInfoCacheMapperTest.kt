package com.efhem.binlist.cache.mappers

import com.efhem.binlist.cache.DummyData
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class CardInfoCacheMapperTest {

    private var cardInfoCacheMapper = CardInfoCacheMapper()

    @Test
    fun `check that mapToModel returns respected data`() {
        val cardInfoEntity = DummyData.entity

        val cardInfoCache = cardInfoCacheMapper.mapToModel(cardInfoEntity)

        assertThat(cardInfoCache.cardNumber).isEqualTo(cardInfoEntity.cardNumber)
        assertThat(cardInfoCache.city).isEqualTo(cardInfoEntity.city)
        assertThat(cardInfoCache.longitude).isEqualTo(cardInfoEntity.longitude)
        assertThat(cardInfoCache.alpha2).isEqualTo(cardInfoEntity.alpha2)
    }

    @Test
    fun `check that mapToEntity returns respected data`() {
        val cardInfoModel = DummyData.CardInfoModel

        val cardInfoEntity = cardInfoCacheMapper.mapToEntity(cardInfoModel)

        assertThat(cardInfoEntity.cardNumber).isEqualTo(cardInfoModel.cardNumber)
        assertThat(cardInfoEntity.city).isEqualTo(cardInfoModel.city)
        assertThat(cardInfoEntity.longitude).isEqualTo(cardInfoModel.longitude)
        assertThat(cardInfoEntity.alpha2).isEqualTo(cardInfoModel.alpha2)
    }

}