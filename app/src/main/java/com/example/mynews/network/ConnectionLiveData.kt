package com.example.mynews.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.lifecycle.MutableLiveData

class ConnectionLiveData constructor(context: Context) : MutableLiveData<Boolean>() {

    private lateinit var networkCallback: ConnectivityManager
    .NetworkCallback

    private val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    init {
        checkValidNetworks()
    }

    private fun checkValidNetworks() {
        postValue(checkInternetConnection())
    }

    private fun checkInternetConnection(): Boolean {
        val nw = cm.activeNetwork ?: return false
        val actNw = cm.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    }

    override fun onActive() {
        networkCallback = createNetworkCallback()
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        cm.registerNetworkCallback(networkRequest, networkCallback)
    }

    private fun createNetworkCallback() = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            checkValidNetworks()
        }

        override fun onLost(network: Network) {
            checkValidNetworks()
        }
    }

    override fun onInactive() {
        cm.unregisterNetworkCallback(networkCallback)
    }
}