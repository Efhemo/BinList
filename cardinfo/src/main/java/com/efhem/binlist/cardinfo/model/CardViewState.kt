package com.efhem.binlist.cardinfo.model

import com.efhem.binlist.domain.model.CardInfo

sealed class CardViewState {
    data class Success(val cardInfo: CardInfo?): CardViewState()
    data class Error(val message: String): CardViewState()
    object Loading: CardViewState()
}