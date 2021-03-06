package com.rim.domain.usecases

import com.rim.domain.common.CallResult
import com.rim.domain.repositories.TravelAdvisorRepository
import com.rim.domain.usecases.base.BaseUseCaseWithInput
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
open class GetUrbanAreaImage(private val travelAdvisorRepository: TravelAdvisorRepository) :
    BaseUseCaseWithInput<String, Flow<CallResult<String>>> {
    override suspend fun invoke(request: String): Flow<CallResult<String>> {
        return travelAdvisorRepository.getUrbanAreaImage(request)
    }
}