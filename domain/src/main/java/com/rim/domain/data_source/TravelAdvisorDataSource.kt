package com.rim.domain.data_source

import com.rim.domain.common.CallResult
import com.rim.domain.models.entity.UrbanArea

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
interface TravelAdvisorDataSource {
    suspend fun getUAScore(uaName: String): UrbanArea?
    suspend fun getUrbanAreasWihScores(): CallResult<List<UrbanArea>>
}