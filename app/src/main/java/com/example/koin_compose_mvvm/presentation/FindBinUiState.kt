package com.example.koin_compose_mvvm.presentation

import com.example.koin_compose_mvvm.domain.entity.MainData

sealed interface FindBinUiState{
    object Initial : FindBinUiState
    object Loading : FindBinUiState
    data class Content(val bin: MainData) : FindBinUiState
    data class Error(val message: String?) : FindBinUiState
}
