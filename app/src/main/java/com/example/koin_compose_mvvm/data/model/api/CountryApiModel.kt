package com.example.koin_compose_mvvm.data.model.api

data class CountryApiModel(
    var numeric: String? = null,
    var alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null
)

