package com.example.koin_compose_mvvm.domain.entity

data class MainData(
    var bin: String,
    var date: String,
    var scheme: String? = null,
    var number: Number,
    var type: String? = null,
    var brand: String? = null,
    var prepaid: String? = null,
    var country: Country,
    var bank: Bank
)