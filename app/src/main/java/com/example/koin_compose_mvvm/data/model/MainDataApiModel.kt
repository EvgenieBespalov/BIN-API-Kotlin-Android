package com.example.koin_compose_mvvm.data.model

data class MainDataApiModel(
    var scheme: String? = null,
    var number: NumberApiModel,
    var type: String? = null,
    var brand: String? = null,
    var prepaid: Boolean? = null,
    var country: CountryApiModel,
    var bank: BankApiModel
)