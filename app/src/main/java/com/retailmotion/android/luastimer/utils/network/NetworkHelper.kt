package com.retailmotion.android.luastimer.utils.network

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Singleton

@Singleton
class NetworkHelper constructor(private val context: Context) {

    fun isNetworkConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }
}