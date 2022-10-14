package com.example.domain.data

sealed class NetworkResult<out T>() {

    data class Success<out T>(val value: T) : NetworkResult<T>()

    data class ResponseError(val error: String? = null) :
        NetworkResult<Nothing>()

    object Loading : NetworkResult<Nothing>()

    data class UnknownError(val error: String? = null) : NetworkResult<Nothing>()


}