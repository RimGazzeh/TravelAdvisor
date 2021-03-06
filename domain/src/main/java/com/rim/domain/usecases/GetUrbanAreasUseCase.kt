package com.rim.domain.usecases

import com.rim.domain.common.CallResult
import com.rim.domain.models.entity.UrbanArea
import com.rim.domain.repositories.TravelAdvisorRepository
import com.rim.domain.usecases.base.BaseUseCaseWithoutInput
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
class GetUrbanAreasUseCase(private val travelAdvisorRepository: TravelAdvisorRepository) :
    BaseUseCaseWithoutInput<Flow<CallResult<List<UrbanArea>>>> {
    override suspend fun invoke(request: Nothing): Flow<CallResult<List<UrbanArea>>> {
        return travelAdvisorRepository.getUrbanAreasWihScores()
    }
}