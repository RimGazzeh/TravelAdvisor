package com.rim.domain.common

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
sealed class CallResult<out T> {
    data class Success<out T>(val data: T) : CallResult<T>()
    data class Error(val exception: CallErrors) : CallResult<Nothing>()
    object Loading : CallResult<Nothing>()
}