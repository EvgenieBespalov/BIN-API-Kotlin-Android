package com.example.koin_compose_mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FindBinViewModel (
    //private val setToNeedNewUsersUseCase: SetToNeedNewUsersUseCase
) : ViewModel() {

    private val _state: MutableLiveData<FindBinUiState> = MutableLiveData(FindBinUiState.Initial)
    val state: LiveData<FindBinUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = FindBinUiState.Initial
        }
    }

    /*fun setNeedToLoadNewUsers(){
        viewModelScope.launch {
            setToNeedNewUsersUseCase(true)
        }
    }*/

}