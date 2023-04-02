package com.example.koin_compose_mvvm.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koin_compose_mvvm.domain.usecase.LoadBinAllUseCase
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class BinHistoryViewModel(
    private val loadBinAllUseCase: LoadBinAllUseCase
) : ViewModel() {

    private val _state: MutableLiveData<BinHistoryUiState> = MutableLiveData(BinHistoryUiState.Initial)
    val state: LiveData<BinHistoryUiState> = _state

    fun loadData(){
        viewModelScope.launch {
            _state.value = BinHistoryUiState.Loading

            try {
                val mainData = loadBinAllUseCase()
                _state.value = mainData.let { BinHistoryUiState.Content(it) }
            } catch (rethrow: CancellationException) {
                throw rethrow
            } catch (ex: Exception) {
                _state.value = BinHistoryUiState.Error(ex.message)
            }
        }
    }

}