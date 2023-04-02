package com.example.koin_compose_mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_compose_mvvm.domain.usecase.GetDataBinUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class FindBinViewModel (
    private val getDataBinUseCase: GetDataBinUseCase
) : ViewModel() {

    private val _state: MutableLiveData<FindBinUiState> = MutableLiveData(FindBinUiState.Initial)
    val state: LiveData<FindBinUiState> = _state

    fun initial() {
        viewModelScope.launch {
            _state.value = FindBinUiState.Initial
        }
    }

    fun getDataBin(bin: String){
        viewModelScope.launch {
            _state.value = FindBinUiState.Loading

            try {
                val users = getDataBinUseCase(bin)
                _state.value = users.let { FindBinUiState.Content(it) }
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = FindBinUiState.Error(ex.message)
            }

        }
    }

}