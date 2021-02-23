package com.efhem.binlist.remote.mapper

import com.efhem.binlist.domain.model.CardInfo
import com.efhem.binlist.remote.mapper.base.RemoteModelMapper
import com.efhem.binlist.remote.model.NetworkResponse
import javax.inject.Inject

class CardInfoEntityMapper @Inject constructor(): RemoteModelMapper<NetworkResponse, CardInfo> {

    override fun mapFromModel(model: NetworkResponse): CardInfo {
        return with(model){
            CardInfo(
                bank?.city,
                bank?.name,
                bank?.phone,
                bank?.url,
                brand,
                country?.alpha2,
                country?.currency,
                country?.emoji,
                country?.latitude,
                country?.longitude,
                country?.name,
                country?.numeric,
                number?.length,
                number?.luhn,
                prepaid, scheme, type
            )
        }
    }
}