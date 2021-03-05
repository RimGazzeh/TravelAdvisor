package com.rim.traveladvisor

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
class TravelAdvisorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
        initStetho()
    }

    private fun initDI() {
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}