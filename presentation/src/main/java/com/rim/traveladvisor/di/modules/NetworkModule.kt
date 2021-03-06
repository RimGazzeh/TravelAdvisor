package com.rim.traveladvisor.di.modules

import com.rim.data.remote.ApiServices
import com.rim.data.remote.config.okHttpBuilder
import com.rim.data.remote.config.retrofitBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Rim Gazzah on 3/5/21.
 **/
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        return okHttpBuilder()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return retrofitBuilder(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)
}