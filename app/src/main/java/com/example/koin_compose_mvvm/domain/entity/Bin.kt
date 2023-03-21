package com.example.koin_compose_mvvm.domain.entity

data class Bin(
    var bin: String? = null,
    var scheme: String? = null,
    var number: Number,
    var type: String? = null,
    var brand: String? = null,
    var prepaid: Boolean? = null,
    var country: Country,
    var bank: Bank
)