package com.rim.domain.repositories

import com.rim.domain.common.CallResult
import com.rim.domain.models.entity.UrbanArea
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
interface TravelAdvisorRepository {
    suspend fun getAllUrbanAreas(): Flow<CallResult<List<String>>>
    suspend fun searchCity(city: String)
    suspend fun getUAScore(uaName: String):Flow<CallResult<UrbanArea>>
}