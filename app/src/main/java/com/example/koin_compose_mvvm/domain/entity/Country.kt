package com.example.koin_compose_mvvm.domain.entity

data class Country(
    var numeric: String? = null,
    var alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null
)

