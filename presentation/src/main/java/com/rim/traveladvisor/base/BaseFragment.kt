package com.rim.traveladvisor.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.rim.traveladvisor.common.FragmentViewBindingDelegate

/**
 * Created by Rim Gazzah on 2/8/21.
 **/
abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    protected fun <T : ViewBinding> viewBinding(viewBindingFactory: (View) -> T) =
        FragmentViewBindingDelegate(this, viewBindingFactory)

    protected inline fun <reified VM : ViewModel> viewModelProvider(factory: ViewModelProvider.Factory) =
        ViewModelProvider(this, factory).get(VM::class.java)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intView()
    }

    protected abstract fun intView()
}
