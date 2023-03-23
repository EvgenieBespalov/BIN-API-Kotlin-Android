package com.example.koin_compose_mvvm.data.api

import com.example.koin_compose_mvvm.domain.entity.MainData
import retrofit2.http.GET

interface BinApi {
    @GET("/")
    suspend fun getData(bin: Int): MainData
}