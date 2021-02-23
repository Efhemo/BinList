package com.efhem.binlist.remote

import com.efhem.binlist.remote.model.NetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("{cardNumber}")
    suspend fun getData(@Path("cardNumber") cardNumber: Long): Response<NetworkResponse>
}