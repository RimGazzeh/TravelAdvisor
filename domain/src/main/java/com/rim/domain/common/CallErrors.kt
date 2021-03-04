package com.rim.domain.common

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
sealed class CallErrors {
    object ErrorEmptyData : CallErrors()
    object ErrorServer: CallErrors()
    data class ErrorException(val throwable: Throwable) : CallErrors()
}