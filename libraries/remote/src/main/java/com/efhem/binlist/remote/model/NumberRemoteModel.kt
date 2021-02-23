package com.efhem.binlist.remote.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberRemoteModel(
    @Json(name = "length")
    val length: Int?,
    @Json(name = "luhn")
    val luhn: Boolean?
)