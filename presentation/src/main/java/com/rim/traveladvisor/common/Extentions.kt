package com.rim.traveladvisor.common

import android.content.Context
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.rim.domain.common.CallErrors
import com.rim.traveladvisor.R

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
fun CallErrors.getErrorMsg(context: Context): String {
    return when (this) {
        is CallErrors.ErrorEmptyData -> context.getString(R.string.error_empty_data)
        is CallErrors.ErrorException -> {
            Log.e(TRAVEL_ADVISOR_LOG, "Operation Error message: ${throwable.message}")
            context.getString(R.string.error_operation)
        }
        else -> context.getString(R.string.error_data)
    }
}

fun View.hide() {
    isVisible = false
}

fun View.show() {
    isVisible = true
}