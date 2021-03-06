package com.rim.traveladvisor.features.detail

import android.text.Html
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import coil.load
import com.rim.domain.common.CallResult
import com.rim.domain.common.fold
import com.rim.domain.models.entity.UrbanArea
import com.rim.traveladvisor.R
import com.rim.traveladvisor.TravelAdvisorApplication
import com.rim.traveladvisor.base.BaseFragment
import com.rim.traveladvisor.common.URBAN_AREA_DATA
import com.rim.traveladvisor.databinding.FragmentUaDetailBinding
import com.rim.traveladvisor.di.viewmodel.DaggerViewModelFactory
import com.rim.traveladvisor.features.dashboard.adapter.ScoreAdapter
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
        if (arguments != null && requireArguments().containsKey(URBAN_AREA_DATA)) {
            urbanArea = requireArguments().getSerializable(URBAN_AREA_DATA) as UrbanArea
            setUAData()
        } else {
            findNavController().popBackStack()
        }
    }

    private fun intObservers() {
        mViewModel.urbanAreasImageResult.observe(viewLifecycleOwner) { result ->
            mBinding.UADetailLoader.isVisible = result is CallResult.Loading
            result.fold(
                onSuccess = {
                    mBinding.UADetailImage.isVisible = true
                    mBinding.UADetailImage.load(it)
                },
                onError = {
                    mBinding.UADetailImage.isVisible = false
                }
            )
        }
        mViewModel.getUAImage(urbanArea.name)
    }

    private fun setUAData() {
        mBinding.UADetailName.text = urbanArea.name
        mBinding.UADetailSummary.text =
            Html.fromHtml(urbanArea.summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
        mBinding.UADetailScores.adapter = ScoreAdapter(urbanArea.categories)
    }
}