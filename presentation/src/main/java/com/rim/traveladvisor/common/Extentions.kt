package com.rim.traveladvisor.common

import android.content.Context
import android.util.Log
import androidx.appcompat.widget.SearchView
import com.rim.domain.common.CallErrors
import com.rim.traveladvisor.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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

inline fun SearchView.onQueryTextChanged(crossinline listener: (StateFlow<String>) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        val queryText = MutableStateFlow("")
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            queryText.value = newText.orEmpty()
            listener(queryText)
            return true
        }
    })
}