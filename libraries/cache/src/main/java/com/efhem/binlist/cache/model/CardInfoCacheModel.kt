package com.efhem.binlist.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CARD_INFO")
class CardInfoCacheModel (
    @PrimaryKey
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