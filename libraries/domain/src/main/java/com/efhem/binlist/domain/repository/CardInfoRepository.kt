package com.efhem.binlist.domain.repository

import com.efhem.binlist.domain.model.CardInfoResult
import kotlinx.coroutines.flow.Flow


interface CardInfoRepository {

    suspend fun getCardInfo(digit: Long): CardInfoResult
}