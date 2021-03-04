package com.rim.traveladvisor.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.rim.traveladvisor.common.FragmentViewBindingDelegate

/**
 * Created by Rim Gazzah on 2/8/21.
 **/
abstract class BaseFragment(@LayoutRes val layoutId: Int) : Fragment(layoutId) {

    protected fun <T : ViewBinding> viewBinding(viewBindingFactory: (View) -> T) =
        FragmentViewBindingDelegate(this, viewBindingFactory)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intObservers()
        intView()
    }

    protected abstract fun intObservers()
    protected abstract fun intView()
}
