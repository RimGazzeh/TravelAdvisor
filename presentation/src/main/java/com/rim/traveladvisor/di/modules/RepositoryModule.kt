package com.rim.traveladvisor.di.modules

import com.rim.data.datasources.remote.TravelAdvisorDataSourceImpl
import com.rim.data.remote.ApiServices
import com.rim.data.remote.repositories.TravelAdvisorRepositoryImpl
import com.rim.domain.data_source.TravelAdvisorDataSource
import com.rim.domain.repositories.TravelAdvisorRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideDataSource(
        apiServices: ApiServices
    ): TravelAdvisorDataSource {
        return TravelAdvisorDataSourceImpl(apiServices)
    }

    @Provides
    @Singleton
    fun provideRepository(travelAdvisorDataSource: TravelAdvisorDataSource): TravelAdvisorRepository {
        return TravelAdvisorRepositoryImpl(travelAdvisorDataSource)
    }
}