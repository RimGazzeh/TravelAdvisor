package com.rim.traveladvisor.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rim.traveladvisor.di.viewmodel.DaggerViewModelFactory
import com.rim.traveladvisor.di.viewmodel.ViewModelKey
import com.rim.traveladvisor.features.dashboard.DashboardViewModel
import com.rim.traveladvisor.features.detail.UADetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UADetailViewModel::class)
    abstract fun bindUADetailViewModel(uaDetailViewModel: UADetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}