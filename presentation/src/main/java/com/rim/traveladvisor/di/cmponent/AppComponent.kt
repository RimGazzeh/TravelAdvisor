package com.rim.traveladvisor.di.cmponent

import com.rim.traveladvisor.di.modules.NetworkModule
import com.rim.traveladvisor.di.modules.RepositoryModule
import com.rim.traveladvisor.di.modules.UseCasesModule
import com.rim.traveladvisor.di.modules.ViewModelModule
import com.rim.traveladvisor.features.dashboard.DashboardFragment
import com.rim.traveladvisor.features.detail.UADetailFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 3/6/21.
 **/
@Singleton
@Component(
    modules = [ViewModelModule::class, RepositoryModule::class, NetworkModule::class, UseCasesModule::class]
)
interface AppComponent {
    fun inject(dashboardFragment: DashboardFragment)
    fun inject(dashboardFragment: UADetailFragment)
}