package com.rim.traveladvisor.features.detail

import androidx.lifecycle.MutableLiveData
import com.rim.domain.common.CallResult
import com.rim.domain.usecases.GetUrbanAreaImage
import com.rim.traveladvisor.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
class UADetailViewModel @Inject constructor(private val getImageUseCase: GetUrbanAreaImage) :
    BaseViewModel() {
    private val _urbanAreasImageResult = MutableLiveData<CallResult<String>>()
    val urbanAreasImageResult get() = _urbanAreasImageResult

    fun getUAImage(uaName: String) {
        launchOnUI {
            getImageUseCase(uaName).collect {
                _urbanAreasImageResult.postValue(it)
            }
        }
    }
}