package com.example.koin_compose_mvvm.domain.repository

import com.example.koin_compose_mvvm.domain.entity.MainData

interface BinRepository {
    suspend fun getDataApi(bin: String): MainData
    suspend fun saveBinDataBase(mainData: MainData)
    suspend fun loadBinByBinDataBase(bin: String): List<MainData>
    suspend fun loadBinAllDataBase(): List<MainData>
}