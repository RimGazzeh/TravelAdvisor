package com.rim.traveladvisor.di.modules

import com.rim.domain.repositories.TravelAdvisorRepository
import com.rim.domain.usecases.GetUrbanAreasUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 3/6/21.
 **/

@Module
class UseCasesModule {
    @Provides
    @Singleton
    fun provideGetUrbanAreasUseCase(repository: TravelAdvisorRepository): GetUrbanAreasUseCase {
        return GetUrbanAreasUseCase(repository)
    }
}