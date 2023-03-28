package com.example.koin_compose_mvvm.data.api

import com.example.koin_compose_mvvm.data.model.MainDataApiModel
import com.example.koin_compose_mvvm.domain.entity.MainData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BinApi {
    @GET("/{bin}")
    suspend fun getData(@Path("bin") bin: Int): MainDataApiModel
}