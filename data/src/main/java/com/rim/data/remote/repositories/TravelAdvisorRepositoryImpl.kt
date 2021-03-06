package com.rim.data.remote.repositories

import com.rim.data.common.applyCommonSideEffects
import com.rim.domain.common.CallResult
import com.rim.domain.data_source.TravelAdvisorDataSource
import com.rim.domain.models.entity.UrbanArea
import com.rim.domain.repositories.TravelAdvisorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
class TravelAdvisorRepositoryImpl(private val dataSource: TravelAdvisorDataSource) :
    TravelAdvisorRepository {

    override suspend fun getUrbanAreasWihScores(): Flow<CallResult<List<UrbanArea>>> = flow {
        emit(dataSource.getUrbanAreasWihScores())
    }.applyCommonSideEffects()
}