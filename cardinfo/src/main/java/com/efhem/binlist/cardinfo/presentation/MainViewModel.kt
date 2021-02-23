package com.efhem.binlist.cardinfo.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.efhem.binlist.cardinfo.model.CardViewState
import com.efhem.binlist.domain.usecases.GetCardInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor (private val cardInfo: GetCardInfo) : ViewModel() {

    private val _uiState = MutableStateFlow<CardViewState>(CardViewState.Success(null))

    val uiState: StateFlow<CardViewState> = _uiState

    fun setCardDigit(digit: Long){

        viewModelScope.launch {
            _uiState.value = CardViewState.Loading

            val cardInfoResult  = cardInfo.execute(digit)
            val data = cardInfoResult.cardInfo
            val error = cardInfoResult.message
            if(error == null){
                _uiState.value = CardViewState.Success(data)
            }else {_uiState.value = CardViewState.Error(error)}
        }
    }
}