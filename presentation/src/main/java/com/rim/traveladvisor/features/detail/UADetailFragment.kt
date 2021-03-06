package com.rim.traveladvisor.features.detail

import com.rim.domain.models.entity.UrbanArea
import com.rim.traveladvisor.R
import com.rim.traveladvisor.TravelAdvisorApplication
import com.rim.traveladvisor.base.BaseFragment
import com.rim.traveladvisor.databinding.FragmentUaDetailBinding
import com.rim.traveladvisor.di.viewmodel.DaggerViewModelFactory
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class UADetailFragment : BaseFragment(R.layout.fragment_ua_detail) {
    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val mViewModel by lazy { viewModelProvider(viewModelFactory) as UADetailViewModel }
    private val mBinding by viewBinding(FragmentUaDetailBinding::bind)
    private lateinit var urbanArea: UrbanArea

    override fun intView() {
        initDI()
        initData()
        intObservers()
    }

    private fun initDI() {
        TravelAdvisorApplication.appComponent.inject(this)
    }

    private fun initData() {
    }

    private fun intObservers() {
        mViewModel.urbanAreasImageResult.observe(viewLifecycleOwner) { result ->

        }
    }
}