package com.rim.data.remote

import com.rim.data.common.PATH_IMAGES
import com.rim.data.common.PATH_KEY_UA_ID
import com.rim.data.common.PATH_SCORES
import com.rim.data.common.PATH_URBAN_AREAS
import com.rim.domain.models.dao.response.all_ua.EUrbanAreaResponse
import com.rim.domain.models.dao.response.image_ua.EImageUA
import com.rim.domain.models.dao.response.score_ua.EUrbanAreaScoreResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Rim Gazzah on 3/4/21.
 **/
interface ApiServices {

    @GET(PATH_URBAN_AREAS)
    suspend fun getAllUrbanAreas(): Response<EUrbanAreaResponse>

    @GET("$PATH_URBAN_AREAS/{$PATH_KEY_UA_ID}/$PATH_SCORES")
    suspend fun getUAScore(@Path(PATH_KEY_UA_ID) uaId: String): Response<EUrbanAreaScoreResponse>

    @GET("$PATH_URBAN_AREAS/{$PATH_KEY_UA_ID}/$PATH_IMAGES")
    suspend fun getUAImage(@Path(PATH_KEY_UA_ID) uaId: String): Response<EImageUA>
}