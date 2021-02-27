package com.efhem.binlist.remote

import com.efhem.binlist.remote.model.BankRemoteModel
import com.efhem.binlist.remote.model.CountryRemoteModel
import com.efhem.binlist.remote.model.NetworkResponse
import com.efhem.binlist.remote.model.NumberRemoteModel

internal object DummyData {

    val bank = BankRemoteModel(
        "Hjørring",
        "Jyske Bank",
        "+4589893300",
        "www.jyskebank.dk"
    )

    val country = CountryRemoteModel(
        "DK",
        "DKK",
        "🇩🇰",
        56,
        10,
        "Denmark",
        "208"
    )

    val number = NumberRemoteModel(
        16, true
    )

    val networkRemoteModel = NetworkResponse(
        bank, "Visa/Dankort", country, number,
        false, "visa", "debit"
    )

}