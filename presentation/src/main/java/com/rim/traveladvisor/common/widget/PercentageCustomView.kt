package com.rim.traveladvisor.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.rim.traveladvisor.R
import com.rim.traveladvisor.databinding.CustomViewProgressPercentageBinding

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
class PercentageCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleRes) {

    private val mBinding =
        CustomViewProgressPercentageBinding.inflate(LayoutInflater.from(context), this, true)

    @StringRes
    private var titleRes: Int

    init {
        attrs.let {
            val typedArray =
                context.obtainStyledAttributes(
                    it,
                    R.styleable.PercentageCustomView,
                    defStyleRes,
                    0
                )
            try {
                titleRes =
                    typedArray.getResourceId(R.styleable.PercentageCustomView_titleProgress, -1)
            } finally {
                typedArray.recycle()
            }
            initView()
        }
    }

    private fun initView() {
        if (titleRes != -1) {
            mBinding.cvProgressTitle.text = context.getString(titleRes)
        }
    }

    fun setTile(@StringRes title: Int): PercentageCustomView {
        titleRes = title
        initView()
        return this
    }

    fun setPercentage(percentageValue: Int): PercentageCustomView {
        mBinding.cvProgressBar.setProgress(percentageValue, true)
        mBinding.cvProgressPercent.text =
            context.getString(R.string.percent, percentageValue.toString())
        return this
    }

}