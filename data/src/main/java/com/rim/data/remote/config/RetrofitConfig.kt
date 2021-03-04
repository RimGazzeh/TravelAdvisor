package com.rim.data.remote.config

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.rim.data.BuildConfig
import com.rim.data.BuildConfig.BASE_URL
import com.rim.data.common.IO_TIMEOUT
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


fun okHttpBuilder(): OkHttpClient {
    val client = OkHttpClient.Builder()
        .connectTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
    if (BuildConfig.DEBUG)
        client.addNetworkInterceptor(StethoInterceptor())
    return client.build()
}

fun buildRetrofit(
    okHttpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}