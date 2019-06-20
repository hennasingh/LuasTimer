package com.retailmotion.android.luastimer.data.remote

import com.retailmotion.android.luastimer.data.Endpoints
import com.retailmotion.android.luastimer.data.remote.response.MarOutboundResponse
import com.retailmotion.android.luastimer.data.remote.response.StiInboundResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.LUAS_FORECAST)
    fun getStiInboundCall(
        @Query("action") action: String,
        @Query("stop") stop: String,
        @Query("encrypt") encrypt: Boolean
    ): Single<StiInboundResponse>

    @GET(Endpoints.LUAS_FORECAST)
    fun getMarOutbound(
        @Query("action") action: String,
        @Query("stop") stop: String,
        @Query("encrypt") encrypt: Boolean
    ): Single<MarOutboundResponse>
}