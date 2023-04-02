package com.example.koin_compose_mvvm.domain.repository

import com.example.koin_compose_mvvm.data.model.database.BinDataBaseModel
import com.example.koin_compose_mvvm.domain.entity.MainData

interface BinRepository {
    suspend fun getDataApi(bin: String): MainData
    suspend fun saveBinData(mainData: MainData)
    suspend fun findBinByBin(bin: String): List<MainData>
    suspend fun findBinAll(): List<MainData>
}