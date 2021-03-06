package com.rim.traveladvisor.features.dashboard

import androidx.lifecycle.MutableLiveData
import com.rim.domain.common.CallResult
import com.rim.domain.models.entity.UrbanArea
import com.rim.domain.usecases.GetUrbanAreasUseCase
import com.rim.traveladvisor.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
class DashboardViewModel @Inject constructor(private val getUrbanAreasUseCase: GetUrbanAreasUseCase) :
    BaseViewModel() {

    private val _urbanAreasResult = MutableLiveData<CallResult<List<UrbanArea>>>()
    val urbanAreasResult get() = _urbanAreasResult

    fun getUrbanAreas() {
        launchOnUI {
            getUrbanAreasUseCase().collect {
                _urbanAreasResult.postValue(it)
            }
        }
    }
}