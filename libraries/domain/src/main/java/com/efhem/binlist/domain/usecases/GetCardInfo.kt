package com.efhem.binlist.domain.usecases

import com.efhem.binlist.domain.executor.PostExecutionThread
import com.efhem.binlist.domain.model.CardInfoResult
import com.efhem.binlist.domain.repository.CardInfoRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetCardInfo @Inject constructor(
    private val repository: CardInfoRepository,
    private val postExecutionThread: PostExecutionThread) {

    suspend fun execute(params: Long): CardInfoResult {
        return withContext(postExecutionThread.io) {
            repository.getCardInfo(params)
        }
    }
}