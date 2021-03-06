package com.rim.data.remote.repositories

import com.rim.data.common.applyCommonSideEffects
import com.rim.data.common.getResult
import com.rim.data.common.getUAIdFromName
import com.rim.data.remote.ApiServices
import com.rim.domain.common.CallResult
import com.rim.domain.models.dao.response.all_ua.mapToUrbanAreaNameList
import com.rim.domain.models.dao.response.score_ua.mapToEntity
import com.rim.domain.models.entity.UrbanArea
import com.rim.domain.repositories.TravelAdvisorRepository
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.flow

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
class TravelAdvisorRepositoryImpl(private val apiServices: ApiServices) : TravelAdvisorRepository {
    override suspend fun getAllUrbanAreas(): Flow<CallResult<List<String>>> = flow {
        apiServices.getAllUrbanAreas().run {
            emit(getResult { mapToUrbanAreaNameList() })
        }
    }.applyCommonSideEffects()

    override suspend fun searchCity(city: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getUAScore(uaName: String): Flow<CallResult<UrbanArea>> = flow {
        apiServices.getUAScore(getUAIdFromName(uaName)).run {
            emit(getResult { mapToEntity(uaName) })
        }
    }.applyCommonSideEffects()

}