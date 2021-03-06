package com.rim.traveladvisor

import android.app.Application
import com.facebook.stetho.Stetho
import com.rim.traveladvisor.di.cmponent.AppComponent
import com.rim.traveladvisor.di.cmponent.DaggerAppComponent

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
class TravelAdvisorApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        initDI()
        initStetho()
    }

    private fun initDI() {
        appComponent = DaggerAppComponent.builder().build()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}