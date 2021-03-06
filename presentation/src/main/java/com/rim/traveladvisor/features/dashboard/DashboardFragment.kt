package com.rim.traveladvisor.features.dashboard

import androidx.core.view.isVisible
import com.rim.domain.common.CallResult
import com.rim.domain.common.fold
import com.rim.domain.models.entity.UrbanArea
import com.rim.traveladvisor.R
import com.rim.traveladvisor.TravelAdvisorApplication
import com.rim.traveladvisor.base.BaseFragment
import com.rim.traveladvisor.common.getErrorMsg
import com.rim.traveladvisor.common.onQueryTextChanged
import com.rim.traveladvisor.databinding.FragmentDashbordBinding
import com.rim.traveladvisor.di.viewmodel.DaggerViewModelFactory
import com.rim.traveladvisor.features.dashboard.adapter.UrbanAreaAdapter
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
class DashboardFragment : BaseFragment(R.layout.fragment_dashbord) {
    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val mViewModel by lazy { viewModelProvider(viewModelFactory) as DashboardViewModel }
    private val mBinding by viewBinding(FragmentDashbordBinding::bind)
    private val mUrbanAreaAdapter = UrbanAreaAdapter()
    private var mListUA: List<UrbanArea> = listOf()

    override fun intView() {
        initDI()
        initUI()
        intObservers()
        initData()
        initEvent()
    }

    private fun initDI() {
        TravelAdvisorApplication.appComponent.inject(this)
    }

    private fun initUI() {
        mBinding.dashboardListUrbanArea.adapter = mUrbanAreaAdapter
    }

    private fun intObservers() {
        mViewModel.urbanAreasResult.observe(viewLifecycleOwner) { result ->
            mBinding.dashboardErrorMessage.isVisible = result is CallResult.Error
            mBinding.dashboardLoader.isVisible = result is CallResult.Loading
            mBinding.dashboardListOperationsGroup.isVisible = result is CallResult.Success
            result.fold(
                onSuccess = {
                    mListUA = it
                    mUrbanAreaAdapter.setData(mListUA)
                },
                onError = {
                    mBinding.dashboardErrorMessage.text = it.getErrorMsg(requireContext())
                }
            )
        }
    }

    private fun initData() {
        mViewModel.getUrbanAreas()
    }

    private fun initEvent() {
        mBinding.dashboardSearchUA.onQueryTextChanged { textQuery ->
            mViewModel.searchUA(textQuery, mListUA) { searchResult ->
                mBinding.dashboardErrorMessage.apply {
                    isVisible = searchResult.isNullOrEmpty()
                    if (searchResult.isNullOrEmpty()) {
                        text = context.getString(R.string.error_empty_data)
                    }
                }
                mUrbanAreaAdapter.setData(searchResult)
            }
        }
    }
}