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
    private var nameRes: Int

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
                nameRes =
                    typedArray.getResourceId(R.styleable.PercentageCustomView_nameProgress, -1)
            } finally {
                typedArray.recycle()
            }
            initView()
        }
    }

    private fun initView() {
        if (nameRes != -1) {
            mBinding.cvProgressName.text = context.getString(nameRes)
        }
    }

    fun setTile(name: String): PercentageCustomView {
        mBinding.cvProgressName.text = name
        return this
    }

    fun setPercentage(percentageValue: Double): PercentageCustomView {
        mBinding.cvProgressBar.setProgress(percentageValue.toInt(), true)
        mBinding.cvProgressPercent.text = "$percentageValue%"
        return this
    }

}