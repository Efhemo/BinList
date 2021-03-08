package com.efhem.binlist.remote.repository

import com.efhem.binlist.domain.repository.CardInfoRepository
import com.efhem.binlist.remote.mapper.CardInfoEntityMapper
import com.efhem.binlist.remote.utils.MATCH_CARD
import com.efhem.binlist.remote.utils.RequestDispatcher
import com.efhem.binlist.remote.utils.makeTestApiService
import okhttp3.mockwebserver.MockWebServer
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class CardInfoRepositoryImpTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var cardInfoRepository: CardInfoRepository
    private val cardInfoEntityMapper: CardInfoEntityMapper = CardInfoEntityMapper()

    @Before
    fun setUp(){
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()
        cardInfoRepository = CardInfoRepositoryImp(makeTestApiService(mockWebServer), cardInfoEntityMapper)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `check that getCardInfo returns data`() = runBlocking {
        val cardInfo = cardInfoRepository.getCardInfo(45717360)

        assertThat(cardInfo.cardInfo).isNotNull()
    }

    @Test
    fun `check that getCardInfo returns correct data`() = runBlocking {
        val cardInfo = cardInfoRepository.getCardInfo(45717360)

        assertThat(cardInfo.cardInfo?.bankName).isEqualTo("Jyske Bank")
        assertThat(cardInfo.cardInfo?.brand).isEqualTo("Visa/Dankort")
        assertThat(cardInfo.cardInfo?.numeric).isEqualTo("208")
        assertThat(cardInfo.cardInfo?.countryName).isEqualTo("Denmark")
        assertThat(cardInfo.cardInfo?.emoji).isEqualTo("🇩🇰")
        assertThat(cardInfo.message).isNull()

    }


    @Test
    fun `check that calling getCardInfo makes request to correct path`() = runBlocking {
        cardInfoRepository.getCardInfo(45717360)
        assertThat(MATCH_CARD).isEqualTo(mockWebServer.takeRequest().path)
    }

    @Test
    fun `check that calling getCardInfo makes a GET request`() = runBlocking {
        cardInfoRepository.getCardInfo(45717360)
        assertThat("GET $MATCH_CARD HTTP/1.1").isEqualTo(mockWebServer.takeRequest().requestLine)
    }

    @Test
    fun `check that getCardInfo returns null data when no matching cards are found`() =
        runBlocking {
            val cardInfo = cardInfoRepository.getCardInfo(231)
            assertThat(cardInfo.cardInfo).isNull()
        }


    @Test
    fun `check that getCardInfo returns error message when no matching cards are found`() =
        runBlocking {
            val cardInfo = cardInfoRepository.getCardInfo(231)
            assertThat(cardInfo.message).isNotNull()
            assertThat(cardInfo.message).isEqualTo("Problem, Check your internet connection")
        }


//    @Test
//    fun `check that getCardInfo returns error message if network call fails`() =
//        runBlocking {
//
//            val throwable: UnknownHostException = assertThrows {
//                suspend { cardInfoRepository.getCardInfo(45717360) }
//            }
//
//            assertThat(errorGetCardInfo.message).isEqualTo("Problem, Check your internet connection")
//        }

}