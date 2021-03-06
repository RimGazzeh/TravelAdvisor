package com.rim.data.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

/**
 * Created by Rim Gazzah on 3/6/21.
 **/

fun <T, V> CoroutineScope.asyncAll(list: List<T>, block: suspend (T) -> V): List<Deferred<V>> {
    return list.map {
        async { block.invoke(it) }
    }
}