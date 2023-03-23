package com.example.koin_compose_mvvm.domain.repository

import com.example.koin_compose_mvvm.domain.entity.MainData

interface BinRepository {
    suspend fun getData(bin: Int): MainData
}