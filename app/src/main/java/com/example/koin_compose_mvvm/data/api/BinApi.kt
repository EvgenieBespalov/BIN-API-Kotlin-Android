package com.example.koin_compose_mvvm.data.api

import com.example.koin_compose_mvvm.data.model.api.MainDataApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {
    @GET("/{bin}")
    suspend fun getDataApi(@Path("bin") bin: String): MainDataApiModel
}