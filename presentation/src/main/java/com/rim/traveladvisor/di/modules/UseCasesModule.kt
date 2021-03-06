package com.rim.traveladvisor.di.modules

import com.rim.domain.repositories.TravelAdvisorRepository
import com.rim.domain.usecases.GetUrbanAreasUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Rim Gazzah on 3/6/21.
 **/

@Module
class UseCasesModule {
    @Provides
    fun provideGetUrbanAreasUseCase(travelAdvisorRepository: TravelAdvisorRepository): GetUrbanAreasUseCase {
        return GetUrbanAreasUseCase(travelAdvisorRepository)
    }
}