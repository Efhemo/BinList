package com.efhem.binlist.remote.repository

import com.efhem.binlist.domain.model.CardInfoResult
import com.efhem.binlist.domain.repository.CardInfoRepository
import com.efhem.binlist.remote.ApiService
import com.efhem.binlist.remote.mapper.CardInfoEntityMapper
import javax.inject.Inject

class CardInfoRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val cardInfoEntityMapper: CardInfoEntityMapper)
    : CardInfoRepository {

    override suspend fun getCardInfo(digit: Long): CardInfoResult {

        return try {
            val result = apiService.getData(digit)
             if(result.isSuccessful && result.body() != null){
                CardInfoResult(cardInfoEntityMapper.mapFromModel(result.body()!!), null)
            } else {
                CardInfoResult(null, result.message())
            }
        }catch (e: Throwable){
            CardInfoResult(null, "Problem, Check your internet connection")
        }

    }

}