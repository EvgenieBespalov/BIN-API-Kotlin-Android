package com.example.koin_compose_mvvm.data.model

data class MainData(
    var scheme: String? = null,
    var number: Number,
    var type: String? = null,
    var brand: String? = null,
    var prepaid: Boolean? = null,
    var country: Country,
    var bank: Bank
)