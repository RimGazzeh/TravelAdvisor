package com.rim.data.common

import com.rim.domain.common.CallErrors
import com.rim.domain.common.CallResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import retrofit2.Response
import java.io.IOException

/**
 * Created by Rim Gazzah on 2/22/21.
 **/
const val MAX_RETRIES = 3L
private const val INITIAL_BACKOFF = 2000L

fun getBackoffDelay(attempt: Long) = INITIAL_BACKOFF * (attempt + 1)

fun <T> Flow<CallResult<T>>.applyCommonSideEffects() =
    retryWhen { cause, attempt ->
        when {
            (cause is IOException && attempt < MAX_RETRIES) -> {
                delay(getBackoffDelay(attempt))
                true
            }
            else -> {
                false
            }
        }
    }.onStart {
        emit(CallResult.Loading)
    }.catch {
        emit(CallResult.Error(CallErrors.ErrorException(throwable = it)))
    }


inline fun <reified T, X> Response<T>.getResult(mapToEntity: T.() -> X): CallResult<X> {
    if (this.isSuccessful) {
        if (this.body() == null) {
            return CallResult.Error(CallErrors.ErrorEmptyData)
        } else {
            if (this.body() is T) {
                return CallResult.Success((this.body() as T).mapToEntity())
            }
        }
    }
    return CallResult.Error(CallErrors.ErrorServer)
}
