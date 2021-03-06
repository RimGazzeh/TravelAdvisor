package com.rim.traveladvisor.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Rim Gazzah on 2/8/21.
 **/
open class BaseViewModel : ViewModel() {

    protected fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }
}