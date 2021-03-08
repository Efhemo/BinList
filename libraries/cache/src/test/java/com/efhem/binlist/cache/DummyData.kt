package com.efhem.binlist.cache

import com.efhem.binlist.cache.model.CardInfoCacheModel
import com.efhem.binlist.data.model.CardInfoEntity

internal object DummyData {

    val entity = CardInfoEntity(
        4122414,
        "Hjørring",
        "Jyske Bank",
        "+4589893300",
        "www.jyskebank.dk",
        "Visa/Dankort",
        "DK",
        "DKK",
        "🇩🇰",
        56,
        10,
        "Denmark",
        "208",
        16,
        true,
        false,
        "visa",
        "debit"
    )

    val CardInfoModel = CardInfoCacheModel(
        4122414,
        "Hjørring",
        "Jyske Bank",
        "+4589893300",
        "www.jyskebank.dk",
        "Visa/Dankort",
        "DK",
        "DKK",
        "🇩🇰",
        56,
        10,
        "Denmark",
        "208",
        16,
        true,
        false,
        "visa",
        "debit"
    )
}