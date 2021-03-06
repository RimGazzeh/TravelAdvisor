package com.rim.domain.common

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
sealed class CallResult<out T> {
    data class Success<out T>(val data: T) : CallResult<T>()
    data class Error(val exception: CallErrors) : CallResult<Nothing>()
    object Loading : CallResult<Nothing>()
}

fun <T> CallResult<T>.fold(
    onSuccess: (T) -> Unit,
    onError: (CallErrors) -> Unit,
    onLoading: (() -> Unit)? = null
) {
    when (this) {
        is CallResult.Success -> {
            onSuccess(data)
        }
        is CallResult.Error -> {
            onError(exception)
        }
        is CallResult.Loading -> {
            if (onLoading != null)
                onLoading()
        }
    }
}