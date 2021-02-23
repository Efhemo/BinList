package com.efhem.binlist.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkResponse(
    @Json(name = "bank")
    val bank: BankRemoteModel?,
    @Json(name = "brand")
    val brand: String?,
    @Json(name = "country")
    val country: CountryRemoteModel?,
    @Json(name = "number")
    val number: NumberRemoteModel?,
    @Json(name = "prepaid")
    val prepaid: Boolean?,
    @Json(name = "scheme")
    val scheme: String?,
    @Json(name = "type")
    val type: String?
)