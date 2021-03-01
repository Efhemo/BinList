package com.efhem.binlist.data.model

data class CardInfoEntity (
    val cardNumber: Long,
    val city: String?,
    val bankName: String?,
    val phone: String?,
    val url: String?,
    val brand: String?,
    val alpha2: String?,
    val currency: String?,
    val emoji: String?,
    val latitude: Int?,
    val longitude: Int?,
    val countryName: String?,
    val numeric: String?,
    val length: Int?,
    val luhn: Boolean?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)