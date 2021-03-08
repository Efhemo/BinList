package com.efhem.binlist.cache.cacheImp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.efhem.binlist.cache.DummyData
import com.efhem.binlist.cache.mappers.CardInfoCacheMapper
import com.efhem.binlist.cache.room.BinListDatabase
import com.efhem.binlist.data.contract.cache.CardInfoCacheRepository
import com.efhem.binlist.data.model.CardInfoEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CardInfoCacheImplTest {

    private lateinit var cardInfoCache: CardInfoCacheRepository
    private lateinit var binListDatabase: BinListDatabase

    @Before
    fun setUp(){
        binListDatabase  = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BinListDatabase::class.java
        ).allowMainThreadQueries().build()

        cardInfoCache = CardInfoCacheImpl(
            binListDatabase.cardInfoDao,
            CardInfoCacheMapper()
        )
    }

    @After
    fun tearDown() {
        binListDatabase.close()
    }

    @Test
    fun `check if saveCardInfo inserts data into database`() = runBlocking{
        val cardInfo: CardInfoEntity = DummyData.entity

        cardInfoCache.saveCardInfo(cardInfo)
        val cardInfoEntity = cardInfoCache.getCardInfoSearches().first().first()

        assertThat(cardInfo.city).isEqualTo(cardInfoEntity.city)
        assertThat(cardInfo.bankName).isEqualTo(cardInfoEntity.bankName)
        assertThat(cardInfo.emoji).isEqualTo(cardInfoEntity.emoji)
        assertThat(cardInfo.prepaid).isEqualTo(cardInfoEntity.prepaid)
        assertThat(cardInfo.cardNumber).isEqualTo(cardInfoEntity.cardNumber)
    }

    @Test
    fun `check that getCardInfoSearches returns the last saved search first`() = runBlocking{
        val cardInfo: CardInfoEntity = DummyData.entity
        val cardInfo1 = DummyData.entity.copy(cardNumber = 4122413)
        val cardInfo2 = DummyData.entity.copy(cardNumber = 1413514)

        cardInfoCache.saveCardInfo(cardInfo)
        cardInfoCache.saveCardInfo(cardInfo1)
        cardInfoCache.saveCardInfo(cardInfo2)

        val cardInfoSearch = cardInfoCache.getCardInfoSearches().first()
        assertThat(cardInfoSearch.size).isEqualTo(3)
        assertThat(cardInfo2).isEqualTo(cardInfoSearch.first())
    }


    @Test
    fun `check that saveSearch replaces already saved item`() = runBlocking{
        val cardInfo: CardInfoEntity = DummyData.entity.copy(4122413)
        val cardInfo1 = DummyData.entity.copy(cardNumber = 4122413)

        cardInfoCache.saveCardInfo(cardInfo)
        cardInfoCache.saveCardInfo(cardInfo1)

        val cardInfoSearch = cardInfoCache.getCardInfoSearches().first()
        assertThat(cardInfoSearch.size).isEqualTo(1)
        assertThat(cardInfoSearch.first()).isEqualTo(cardInfo)
    }


}