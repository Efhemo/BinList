package com.efhem.binlist.remote.utils


import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class RequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            MATCH_CARD -> {
                MockResponse()
                        .setResponseCode(HttpURLConnection.HTTP_OK)
                        .setBody(getJson("response/successful_card_info.json"))
            }
//            NO_MATCH_CARD -> {
//                MockResponse()
//                    .setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
//                    .setBody(getJson("response/not_found.json"))
//            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}
