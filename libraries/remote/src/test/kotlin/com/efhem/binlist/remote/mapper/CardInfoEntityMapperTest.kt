package com.efhem.binlist.remote.mapper

import com.efhem.binlist.remote.DummyData
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class CardInfoEntityMapperTest {

    private var cardInfoEntityMapper = CardInfoEntityMapper()

    @Test
    fun `check that mapFromModel returns correct data`(){

        val cardInfoRemote = DummyData.networkRemoteModel
        val cardInfo = cardInfoEntityMapper.mapFromModel(cardInfoRemote)
        assertThat(cardInfoRemote.bank?.name).isEqualTo(cardInfo.bankName)
        assertThat(cardInfoRemote.brand).isEqualTo(cardInfo.brand)
        assertThat(cardInfoRemote.country?.name).isEqualTo(cardInfo.countryName)
        assertThat(cardInfoRemote.number?.length).isEqualTo(cardInfo.length)
        assertThat(cardInfoRemote.scheme).isEqualTo(cardInfo.scheme)

    }
}