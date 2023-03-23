package com.example.koin_compose_mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BinHistoryViewModel(
    //private val setToNeedNewUsersUseCase: SetToNeedNewUsersUseCase
) : ViewModel() {

    private val _state: MutableLiveData<BinHistoryUiState> = MutableLiveData(BinHistoryUiState.Initial)
    val state: LiveData<BinHistoryUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = BinHistoryUiState.Initial
        }
    }

    /*fun setNeedToLoadNewUsers(){
        viewModelScope.launch {
            setToNeedNewUsersUseCase(true)
        }
    }*/

}