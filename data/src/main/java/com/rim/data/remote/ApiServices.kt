package com.rim.data.remote

import com.rim.data.common.*
import com.rim.domain.models.dao.response.all_ua.EUrbanAreaResponse
import com.rim.domain.models.dao.response.score_ua.EUrbanAreaScoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
interface ApiServices {

    @GET(PATH_URBAN_AREAS)
    suspend fun getAllUrbanAreas(): Response<EUrbanAreaResponse>

    @GET(PATH_CITIES)
    suspend fun searchCity(@Query(QUERY_KEY_SEARCH) city: String)

    @GET("$PATH_URBAN_AREAS /{$PATH_KEY_UA_ID}/$PATH_SCORES")
    suspend fun getUAScore(@Part(PATH_KEY_UA_ID) uaId: String): Response<EUrbanAreaScoreResponse>
}