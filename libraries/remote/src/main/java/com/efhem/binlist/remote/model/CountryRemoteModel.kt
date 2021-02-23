package com.efhem.binlist.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryRemoteModel(
    @Json(name = "alpha2")
    val alpha2: String?,
    @Json(name = "currency")
    val currency: String?,
    @Json(name = "emoji")
    val emoji: String?,
    @Json(name = "latitude")
    val latitude: Int?,
    @Json(name = "longitude")
    val longitude: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "numeric")
    val numeric: String?
)