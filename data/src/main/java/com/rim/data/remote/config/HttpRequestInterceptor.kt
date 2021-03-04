package com.rim.data.remote.config

import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response = chain.request().let {
    val newRequest = chain.request().newBuilder()
        //.addHeader(HEADER_AUTHORIZATION, BuildConfig.ACCESS_TOKEN)
        .build()

    chain.proceed(newRequest)
  }
}