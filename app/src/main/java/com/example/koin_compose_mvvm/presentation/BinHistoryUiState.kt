package com.example.koin_compose_mvvm.presentation

import com.example.koin_compose_mvvm.domain.entity.MainData

sealed interface BinHistoryUiState{
    object Initial : BinHistoryUiState
    object Loading : BinHistoryUiState

    data class Content(val mainData: List<MainData>) : BinHistoryUiState

    data class Error(val message: String?) : BinHistoryUiState
}
