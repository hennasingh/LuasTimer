package com.retailmotion.android.luastimer.data.repository

import com.retailmotion.android.luastimer.data.model.Direction
import com.retailmotion.android.luastimer.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WebRepository @Inject constructor(
    private val networkService: NetworkService
) {

    fun doStiInboundCall(action: String, stop: String, encrypt: Boolean): Single<List<Direction>> =
        networkService.getStiInboundCall(action, stop, encrypt)
            .map {
                it.direction
            }

    fun doMarOutboundCall(action: String, stop: String, encrypt: Boolean): Single<List<Direction>> =
        networkService.getMarOutbound(action, stop, encrypt)
            .map {
                it.direction
            }
}